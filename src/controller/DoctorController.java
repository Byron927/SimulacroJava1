package controller;

import entity.Doctor;
import model.DoctorModel;

import javax.swing.*;

public class DoctorController {
    //todos los controller son static porque de ahi podemos acceder a sus metodos
    public static void doctorCreate() {
        //Este objeto lo traemos para acceder a sus métodos. Esto es un objeto de la clase doctor.
        DoctorModel objModelDoctor = new DoctorModel();
        //Este objeto se lo pasamos al metodo crear, propio de la clase DoctorModel
        Doctor objDoctor = new Doctor();

        String name = JOptionPane.showInputDialog("Insert the doctor name");
        String lastname = JOptionPane.showInputDialog("Insert the doctor lastname");
        int specialtyId = Integer.parseInt(JOptionPane.showInputDialog(SpecialityController.specialtyListString() + "Insert the doctor specialty id"));

        objDoctor.setName(name);
        objDoctor.setLastname(lastname);
        objDoctor.setSpecialtyId(specialtyId);

        Doctor doctor = (Doctor) objModelDoctor.create(objDoctor);
        JOptionPane.showMessageDialog(null, doctor + "\nThe doctor has been created correctly");

    }

    public static void doctorList() {
        DoctorModel objDoctorModel = new DoctorModel();
        String doctorsList = "DOCTORS LIST \n";

        for (Object doctorObj : objDoctorModel.listar()) {
            doctorsList += (Doctor) doctorObj + "\n";
        }

        JOptionPane.showMessageDialog(null, doctorsList);
    }

    public static String doctorStringList() {
        DoctorModel objDoctorModel = new DoctorModel();
        String doctorsList = "DOCTORS LIST \n";

        for (Object doctorObj : objDoctorModel.listar()) {
            doctorsList += (Doctor) doctorObj + "\n";
        }

        return doctorsList;
    }

    public static void doctorUpdate() {
        DoctorModel objUpdateDoctor = new DoctorModel();
        Doctor objDoctor = new Doctor();

        int doctorId = Integer.parseInt(JOptionPane.showInputDialog(doctorStringList() + "\n What is the doctor that you want to update?"));

        String name = JOptionPane.showInputDialog("What is the doctor name that you want to update?");
        String lastname = JOptionPane.showInputDialog("What is the doctor lastname that you want to update?");
        int specialty_id = JOptionPane

    }
}
