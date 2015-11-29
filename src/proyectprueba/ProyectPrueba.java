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
        
        WorkWithDatabase prueba = new WorkWithDatabase();
        prueba.createNewDatabase("prueba_de_database.db");
        prueba.showDatabase("*", "vicentillo");
        //prueba.queryForDatabase("create table IF NOT EXISTS vicentillo (id integer, name string)");
        //prueba.InsertData("vicentillo", "2, 'luis'");
        
        
    } // end of main program
    
} //End of main class of program
