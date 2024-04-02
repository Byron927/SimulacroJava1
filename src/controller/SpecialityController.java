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

    public static void specialtyList() {
        //Traemos el objModel para acceder a sus metodos
        SpecialityModel objSpecialtyModel = new SpecialityModel();
        //Creamos String vacio para poderlo mostrar en JOptionpain, porque no queremos el objeto como tal
        //sino que necesitamos recorrer para mostrar los String que hay en el objeto
        String specialtiesList = "SPECIALTIES LIST \n";
    //Sintaxis foreach: for(tipo de dato, nombre variable(el que va a iterar) : esto es un arraylist de Object)
        for (Object specialtyObj : objSpecialtyModel.listar()) {
            specialtiesList += (Speciality) specialtyObj + "\n" ;
        }

        JOptionPane.showMessageDialog(null,specialtiesList);


    }
}
