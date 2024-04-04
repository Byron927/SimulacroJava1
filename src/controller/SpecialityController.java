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

        JOptionPane.showMessageDialog(null, "The specialty has been created correctly\n" + specialtyString);
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

    //Esta lista de string se crea para mostrar en el JOptionpane las especialidades que se desean actualizar
    public static String specialtyListString() {
        //Traemos el objModel para acceder a sus metodos
        SpecialityModel objSpecialtyModel = new SpecialityModel();
        //Creamos String vacio para poderlo mostrar en JOptionpain, porque no queremos el objeto como tal
        //sino que necesitamos recorrer para mostrar los String que hay en el objeto
        String specialtiesList = "SPECIALTIES LIST \n";
        //Sintaxis foreach: for(tipo de dato, nombre variable(el que va a iterar) : esto es un arraylist de Object)
        for (Object specialtyObj : objSpecialtyModel.listar()) {
            specialtiesList += (Speciality) specialtyObj + "\n";
        }

        return specialtiesList;
    }

    public static void specialtyUpdate() {
        //Para acceder a los métodos del modelo
        SpecialityModel objUpdatedModel = new SpecialityModel();
        //Lo que voy a mandar al constructor vacío
        Speciality objSpeciality = new Speciality();

        int specialtyId = Integer.parseInt(JOptionPane.showInputDialog(specialtyListString() + "\nWhat is the specialty id that you want to update?"));
        String name = JOptionPane.showInputDialog("What is the specialty name that you want to update?");
        String description = JOptionPane.showInputDialog("What is the specialty description that you want to update?");

        //Traigo el id para poder ver cuál deseo editar
        objSpeciality.setId(specialtyId);
        objSpeciality.setName(name);
        objSpeciality.setDescription(description);
        objUpdatedModel.update(objSpeciality);
    }

    public static void specialtyDelete() {
        SpecialityModel objDeleteModel = new SpecialityModel();
        Speciality objSpeciality = new Speciality();

        int specialtyId = Integer.parseInt(JOptionPane.showInputDialog(specialtyListString() + "\nWhat is the specialty id that you want to delete?"));

        objSpeciality.setId(specialtyId);

        objDeleteModel.delete(objSpeciality);
    }
}
