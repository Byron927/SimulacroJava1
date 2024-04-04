package model;

import database.configDB;
import entity.Patient;
import interfaces.CRUD;

import java.sql.Connection;
import java.util.ArrayList;

public class PatientModel implements CRUD {

    @Override
    public ArrayList<Object> listar() {
        return null;
    }

    @Override
    public Object create(Object obj) {
        Patient objPatient = (Patient) obj;
        Connection objConnection = configDB.openConnection();



        return null;
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
