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
}
