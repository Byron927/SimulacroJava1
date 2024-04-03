package model;

import database.configDB;
import entity.Doctor;
import entity.Speciality;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoctorModel implements CRUD {

    @Override
    public ArrayList<Object> listar() {
        ArrayList<Object> doctorList = new ArrayList<>();
        Connection objConnection = configDB.openConnection();

        try {
            String sql = "SELECT * FROM doctor";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                //En cada iteración necesitamos que se agregue un objeto al arraylist
                Doctor objDoctor = new Doctor();
                objDoctor.setId(objResult.getInt("doctor_id"));
                objDoctor.setSpecialtyId(objResult.getInt("specialtyId"));
                objDoctor.setName(objResult.getString("doctor_name"));
                objDoctor.setLastname(objResult.getString("doctor_lastname"));

                doctorList.add(objDoctor);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"
                    + e.getMessage());
        }

        return doctorList;
    }

    @Override
    public Object create(Object obj) {
        Doctor objDoctor = (Doctor) obj;
        Connection objConnection = configDB.openConnection();

        try {
            String sql = "INSERT INTO doctor (doctor_name, doctor_lastname, specialtyId) VALUES (?, ?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objDoctor.getName());
            objPrepare.setString(2, objDoctor.getLastname());
            objPrepare.setInt(3, objDoctor.getSpecialtyId());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()){
                objDoctor.setId((objResult.getInt(1)));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"
                    + e.getMessage());
        }
        return objDoctor;
    }

    @Override
    public boolean update(Object obj) {
        Doctor objDoctor = (Doctor) obj;
        Connection objConnection = configDB.openConnection();
        boolean isUpdate = false;

        try {
            String sql = "UPDATE doctor SET doctor_name = ?, doctor_lastname = ?, specialtyId = ? WHERE doctor_id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objDoctor.getName());
            objPrepare.setString(2, objDoctor.getLastname());
            objPrepare.setInt(3, objDoctor.getSpecialtyId());
            objPrepare.setInt(4, objDoctor.getId());

            int affectedRows = objPrepare.executeUpdate();

            if (affectedRows > 0) {
                isUpdate = true;
                JOptionPane.showMessageDialog(null, "Successfully Updated");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return isUpdate;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }
}
