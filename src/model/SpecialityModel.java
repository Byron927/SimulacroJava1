package model;

import database.configDB;
import entity.Speciality;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SpecialityModel implements CRUD {

    @Override
    public ArrayList<Object> listar() {
        ArrayList<Object> specialtyList = new ArrayList<>();
        Connection objConnection = configDB.openConnection();

        try {
            String sql = "SELECT * FROM specialty";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //ResultSet se usa siempre para listar, por id, por nombre, por lo que sea...
            ResultSet objResult = objPrepare.executeQuery();

            //Mientras que haya un resultado en objResult, él irá iterando hacia el
            //siguiente resultado...
            while (objResult.next()) {
                Speciality objSpecialty = new Speciality();
                objSpecialty.setId(objResult.getInt("specialty_id"));
                objSpecialty.setName(objResult.getString("name"));
                objSpecialty.setDescription(objResult.getString("description"));
                specialtyList.add(objSpecialty);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"
                    + e.getMessage());
        }

        return specialtyList;
    }

    @Override
    public Object create(Object obj) {
        Speciality objSpeciality = (Speciality) obj;
        Connection objConnection = configDB.openConnection();

        try {
            String sql = "INSERT INTO specialty (name, description) VALUES (?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objSpeciality.getName());
            objPrepare.setString(2, objSpeciality.getDescription());

            objPrepare.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"
                    + e.getMessage());
        }
        return objSpeciality;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }
}
