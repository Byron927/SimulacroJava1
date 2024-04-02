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

        Speciality specialtyString = (Speciality) objModel.create(objSpeciality);

        JOptionPane.showMessageDialog(null, "The user has been created correctly\n" + specialtyString);
    }

    public static void specialtyList() {
        //Traemos el objModel para acceder a sus metodos
        SpecialityModel objSpecialtyModel = new SpecialityModel();
        //Creamos String vacio para poderlo mostrar en JOptionpain, porque no queremos el objeto como tal
        //sino que necesitamos recorrer para mostrar los String que hay en el objeto
        String specialtiesList = "SPECIALTIES LIST \n";
        //Sintaxis foreach: for(tipo de dato, nombre variable(el que va a iterar) : esto es un arraylist de Object)
        for (Object specialtyObj : objSpecialtyModel.listar()) {
            specialtiesList += (Speciality) specialtyObj + "\n";
        }

        JOptionPane.showMessageDialog(null, specialtiesList);


    }

    public static void specialtyUpdate() {
        //Para acceder a los métodos del modelo
        SpecialityModel objUpdatedModel = new SpecialityModel();
        //Lo que voy a mandar
        Speciality objSpeciality = new Speciality();

        int specialtyId = Integer.parseInt(JOptionPane.showInputDialog("What is the specialty id that you want to update?"));
        String name = JOptionPane.showInputDialog("What is the specialty name that you want to update?");
        String description = JOptionPane.showInputDialog("What is the specialty description that you want to update?");

        objSpeciality.setId(specialtyId);
        objSpeciality.setName(name);
        objSpeciality.setDescription(description);

        if (objUpdatedModel.update(objSpeciality)){
            JOptionPane.showMessageDialog(null, "The specialty has been modified successfully");
        }else{
            JOptionPane.showMessageDialog(null, "The specialty with this ID does not exist");
        }

    }
}
