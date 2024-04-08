package controller;

import entity.Appointment;
import entity.Patient;
import model.AppointmentModel;
import model.PatientModel;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AppointmentController {

    public static void appointmentCreate() {
        AppointmentModel objModel = new AppointmentModel();
        Appointment objAppointment = new Appointment();
        String date = JOptionPane.showInputDialog("Enter the date (YYYY-MM-DD) of the new appointment: ");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDate.parse(date, dateFormat);
            String hour = JOptionPane.showInputDialog("Insert the hour (HH:MM:SS) of the new appointment: ");
            try {
                LocalTime appointmentHour = LocalTime.parse(hour);
                String reason = JOptionPane.showInputDialog("Insert the appointment reason: ");
                int patientAppointment = Integer.parseInt(JOptionPane.showInputDialog(PatientController.patientStringList() + "\nInsert the patient id of the new appointment: "));
                int doctorAppointment = Integer.parseInt(JOptionPane.showInputDialog(DoctorController.doctorStringList() + "\nInsert the doctor id of the new appointment: "));
                objAppointment.setDate(date);
                objAppointment.setHour(hour);
                objAppointment.setReason(reason);
                objAppointment.setPatientId(patientAppointment);
                objAppointment.setDoctorId(doctorAppointment);
                objAppointment = (Appointment) objModel.create(objAppointment);
                JOptionPane.showMessageDialog(null, objAppointment.toString());
            } catch (DateTimeParseException error) {
                JOptionPane.showMessageDialog(null, "The hour format entered is not valid!");
            }
        } catch (DateTimeParseException error) {
            JOptionPane.showMessageDialog(null, "The date format entered is not valid!");
        }
    }
}
