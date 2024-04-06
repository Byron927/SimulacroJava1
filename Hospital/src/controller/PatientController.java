package controller;

import entity.Patient;
import model.PatientModel;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PatientController {
    public static void patientCreate() {
        PatientModel objPatientModel = new PatientModel();
        Patient objPatient = new Patient();

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

    public static void patientList() {
        PatientModel objPatientModel = new PatientModel();
        String patientsList = "PATIENTS LIST \n";

        for (Object patientObj : objPatientModel.listar()) {
            patientsList += (Patient) patientObj + "\n";
        }

        JOptionPane.showMessageDialog(null, patientsList);
    }

    public static String patientStringList() {
        PatientModel objPatientModel = new PatientModel();
        String patientsList = "PATIENTS LIST \n";

        for (Object patientObj : objPatientModel.listar()) {
            patientsList += (Patient) patientObj + "\n";
        }

        return patientsList;
    }

    public static void patientUpdate() {
        PatientModel objModelUpdate = new PatientModel();

        int patientId = Integer.parseInt(JOptionPane.showInputDialog(patientStringList() + "\n What is the patient id that you want to update?"));
        Patient objPatient = objModelUpdate.findById(patientId);

        //Agregando validacion para el paciente
        if (objPatient == null) {
            JOptionPane.showMessageDialog(null, "Patient not found");
        } else {
            String name = JOptionPane.showInputDialog("What is the patient name that you want to update?", objPatient.getName());
            if (name == null) {
                // Cerrar el programa
                System.exit(0);
            }
            String lastName = JOptionPane.showInputDialog("What is the patient lastname that you want to update?", objPatient.getLastname());
            if (lastName == null) {
                System.exit(0);
            }
            String bornDate = JOptionPane.showInputDialog("What is the patient born date that you want to update?", objPatient.getBorndate());
            if (bornDate == null) {
                System.exit(0);
            }
            String dni = JOptionPane.showInputDialog("What is the patient dni that you want to update?", objPatient.getDni());
            if (dni == null) {
                System.exit(0);
            }
          /*  DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            if (dateFormat == null) {
                System.exit(0);
            }*/

            objPatient.setName(name);
            objPatient.setLastname(lastName);
            objPatient.setBorndate(bornDate);
            objPatient.setDni(dni);
            objModelUpdate.update(objPatient);
        }
    }
}


