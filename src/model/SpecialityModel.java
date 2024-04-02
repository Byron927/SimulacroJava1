package model;

import database.configDB;
import entity.Speciality;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SpecialityModel implements CRUD {

    @Override
    public ArrayList<Object> listar() {
        return null;
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
