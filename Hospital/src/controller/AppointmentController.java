package controller;

import entity.Appointment;
import entity.Patient;
import model.AppointmentModel;
import model.PatientModel;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AppointmentController {

    public static void appointmentCreate() {
        AppointmentModel objAppointmentModel = new AppointmentModel();
        Appointment objAppointment = new Appointment();

        String name = JOptionPane.showInputDialog("Insert the new patient name");
        String lastname = JOptionPane.showInputDialog("Insert the new patient lastname");
        String dni = JOptionPane.showInputDialog("Insert the patient DNI");

        String born_date = JOptionPane.showInputDialog("Insert the new patient born date (YYYY-MM-DD)");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDate.parse(born_date, dateFormat);

            objPatient.setName(name);
            objPatient.setLastname(lastname);
            objPatient.setBorndate(born_date);
            objPatient.setDni(dni);

            Patient patient = (Patient) objPatientModel.create(objPatient);
            JOptionPane.showMessageDialog(null, patient + "\n Patient has been successfully created");

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

}
