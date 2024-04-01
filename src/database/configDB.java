package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class configDB {
    public static Connection objConnection = null;

    public static Connection openConnection() {
        try {
            //Llamamos el driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Creamos las variables de conexión
            String url = "jdbc:mysql://localhost:3306/hospital";
            String user = "root";
            String password = "Rlwl2023.";

            //Establecer la conexión
            objConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Me conecté perfectamente!!!!");

        } catch (ClassNotFoundException error) {
            System.out.println("ERROR >> Driver no Instalado " + error.getMessage());
        } catch (SQLException error) {
            System.out.println("ERROR >> error al conectar con la base de datos" + error.getMessage());
        }

        return objConnection;
    }

    public static void closeConnection() {
        try {
            //Si hay una conexión activa entonces la cierra
            if (objConnection != null) {
                objConnection.close();
                System.out.println("Se finalizó la conexión con éxito");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
