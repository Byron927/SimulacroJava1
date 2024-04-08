import controller.DoctorController;
import controller.PatientController;
import controller.SpecialityController;
import database.configDB;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int option = 0, specialtyOption = 0, patientOption = 0, doctorOption = 0, appointmentOption = 0;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. CRUD Specialty
                    2. CRUD patient
                    3. CRUD Doctor
                    4. CRUD appointment
                    5. Exit
                                        
                    Enter the option:
                    """));

            switch (option) {
                case 1:
                    do {

                        specialtyOption = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Create Specialty.
                                2. List of the Specialty's.
                                3. Update Specialty by id.
                                4. Delete Specialty
                                5. Exit
                                            
                                Enter the option:
                                """));

                        switch (specialtyOption) {
                            case 1:
                                SpecialityController.specialityCreate();
                                break;
                            case 2:
                                SpecialityController.specialtyList();
                                break;
                            case 3:
                                SpecialityController.specialtyUpdate();
                                break;
                            case 4:
                                SpecialityController.specialtyDelete();
                        }

                    } while (specialtyOption != 5);
                    break;
                case 2:
                    do {
                        patientOption = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Create Patient.
                                2. List of the Patient's.
                                3. Find by Patient dni.
                                4. Update Patient by id.
                                5. Delete Patient
                                6. Exit
                                            
                                Enter the option:
                                """));

                        switch (patientOption) {
                            case 1:
                                PatientController.patientCreate();
                                break;
                            case 2:
                                PatientController.patientList();
                                break;
                            case 3:
                                PatientController.findByDni();
                                break;
                            case 4:
                                PatientController.patientUpdate();
                                break;
                            case 5:
                                PatientController.patientDelete();
                                break;
                        }

                    } while (patientOption != 6);
                    break;
                case 3:
                    do {
                        doctorOption = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Create Doctor.
                                2. List of the Doctor's.
                                3. Find by id specialty to the doctor.
                                4. Update Doctor by id.
                                5. Delete Doctor.
                                6. Exit
                                            
                                Enter the option:
                                """));

                        switch (doctorOption) {
                            case 1:
                                DoctorController.doctorCreate();
                                break;
                            case 2:
                                DoctorController.doctorList();
                                break;
                           /* case 3:
                                DoctorController.doctorBySpecialty();
                                break;*/
                            case 4:
                                DoctorController.doctorUpdate();
                                break;
                            case 5:
                                DoctorController.doctorDelete();
                                break;
                        }

                    } while (doctorOption != 6);
                    break;
                /*case 4:
                    do {
                        appointmentOption = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. Create Appointment.
                    2. List of the Appointment's.
                    3. Find appointment by date.
                    4. Update Appointment by id.
                    5. Delete Appointment.

                    6. Exit

                    Enter the desired option:
                    """));

                        switch (appointmentOption) {
                            case 1:
                                AppointmentController.appointmentCreate();
                                break;
                            case 2:
                                AppointmentController.appointmentList();
                                break;
                            case 3:
                                AppointmentController.appointmentDate();
                                break;
                            case 4:
                                AppointmentController.appointmentUpdate();
                                break;
                            case 5:
                                AppointmentController.appointmentDelete();
                                break;
                        }

                    }while (appointmentOption != 6);
                    break;*/
            }


        } while (option != 5);
    }
}