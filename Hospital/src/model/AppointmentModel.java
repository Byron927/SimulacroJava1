package model;

import database.configDB;
import entity.Appointment;
import entity.Patient;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppointmentModel implements CRUD {
    @Override
    public ArrayList<Object> listar() {
        return null;
    }

    @Override
    public Object create(Object obj) {
        Appointment objAppointment = (Appointment) obj;
        Connection objConnection = configDB.openConnection();

        try {
            String sql = "INSERT INTO appointment (patientId, doctorId, appointment_date, appointment_hour, reason) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setInt(1, objAppointment.getPatientId());
            objPrepare.setInt(2, objAppointment.getDoctorId());
            objPrepare.setString(3, objAppointment.getDate());
            objPrepare.setString(4, objAppointment.getHour());
            objPrepare.setString(5, objAppointment.getReason());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()) {
                objAppointment.setId(objResult.getInt(1));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"
                    + e.getMessage());
        }

        configDB.closeConnection();

        return objAppointment;
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
