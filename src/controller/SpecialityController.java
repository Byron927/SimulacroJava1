package controller;

import entity.Speciality;
import model.SpecialityModel;

import javax.swing.*;

public class SpecialityController {
    public static void specialityCreate() {
        SpecialityModel objModel = new SpecialityModel();
        Speciality objSpeciality = new Speciality();

        String name = JOptionPane.showInputDialog("Insert the speciality name");
        String description = JOptionPane.showInputDialog("Insert the speciality description");

        objSpeciality.setName(name);
        objSpeciality.setDescription(description);

        objModel.create(objSpeciality);
    }
}
