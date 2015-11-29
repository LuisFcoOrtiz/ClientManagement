/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectprueba;

import database.WorkWithDatabase;
import java.sql.SQLException;

/**
 *
 * @author LFOM
 */
public class ProyectPrueba {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    //Principal function of the program
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        WorkWithDatabase musicDatabase = new WorkWithDatabase();
        musicDatabase.createNewDatabase("musicDatabase.db");
        musicDatabase.createTable("prueba", "ID int primary key,"
                + "name VARCHAR(30) not null,"
                + "duration int not null");
    } // end of main program
    
} //End of main class of program
