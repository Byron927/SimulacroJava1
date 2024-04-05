package model;

import database.configDB;
import entity.Doctor;
import entity.Patient;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PatientModel implements CRUD {

    @Override
    public ArrayList<Object> listar() {
        ArrayList<Object> patientList = new ArrayList<>();
        Connection objConnection = configDB.openConnection();

        try {
            String sql = "SELECT * FROM patient";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                //En cada iteración necesitamos que se agregue un objeto al arraylist
                Patient objPatient = new Patient();
                objPatient.setId(objResult.getInt("patient_id"));
                objPatient.setName(objResult.getString("patient_name"));
                objPatient.setLastname(objResult.getString("patient_lastname"));
                objPatient.setBorndate(objResult.getString("born_date"));
                objPatient.setDni(objResult.getString("dni"));
                patientList.add(objPatient);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"
                    + e.getMessage());
        }

        configDB.closeConnection();
        return patientList;
    }

    @Override
    public Object create(Object obj) {
        Patient objPatient = (Patient) obj;
        Connection objConnection = configDB.openConnection();

        try {
            String sql = "INSERT INTO patient (patient_name, patient_lastname, born_date, dni) VALUES (?, ?, ?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objPatient.getName());
            objPrepare.setString(2, objPatient.getLastname());
            objPrepare.setString(3, objPatient.getBorndate());
            objPrepare.setString(4, objPatient.getDni());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()) {
                objPatient.setId(objResult.getInt(1));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"
                    + e.getMessage());
        }

        configDB.closeConnection();
        return objPatient;
    }

    @Override
    public boolean update(Object obj) {
        Patient objPatient = (Patient) obj;
        Connection objConnection = configDB.openConnection();
        boolean isUpdate = false;

        try {
            String sql = "UPDATE patient SET patient_name = ?, patient_lastname = ?, born_date = ?, dni = ? WHERE patient_id = ?;";


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        configDB.closeConnection();
        return isUpdate;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }
}
