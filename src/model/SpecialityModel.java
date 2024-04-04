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

        configDB.closeConnection();
        return specialtyList;
    }

    @Override
    public Object create(Object obj) {
        Speciality objSpeciality = (Speciality) obj;
        Connection objConnection = configDB.openConnection();

        try {
            String sql = "INSERT INTO specialty (name, description) VALUES (?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objSpeciality.getName());
            objPrepare.setString(2, objSpeciality.getDescription());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()) {
                objSpeciality.setId(objResult.getInt(1));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"
                    + e.getMessage());
        }

        configDB.closeConnection();
        return objSpeciality;
    }

    @Override
    public boolean update(Object obj) {
        Speciality objSpeciality = (Speciality) obj;
        Connection objConnection = configDB.openConnection();
        boolean isUpdate = false;

        try {
            String sql = "UPDATE specialty SET name = ?, description = ? WHERE specialty_id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objSpeciality.getName());
            objPrepare.setString(2, objSpeciality.getDescription());
            objPrepare.setInt(3, objSpeciality.getId());

            int rowsAffected = objPrepare.executeUpdate();

            if (rowsAffected > 0) {
                isUpdate = true;
                JOptionPane.showMessageDialog(null, "Successfully Updated");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {

            configDB.closeConnection();
        }

        return isUpdate;
    }

    @Override
    public boolean delete(Object obj) {

        boolean isDeleted = false;

        Speciality objSpeciality = (Speciality) obj;
        Connection objConnection = configDB.openConnection();
        try {
            String sql = "DELETE FROM specialty WHERE specialty_id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objSpeciality.getId());

            int affectedRows = objPrepare.executeUpdate();

            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Specialty successfully deleted");
                isDeleted = true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"
                    + e.getMessage());
        }

        configDB.closeConnection();
        return false;
    }
}
