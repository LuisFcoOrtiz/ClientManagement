/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectprueba;

import database.WorkWithDatabase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        
        WorkWithDatabase dataBase = new WorkWithDatabase();
        dataBase.createNewDatabase("pagos.db");
        dataBase.InsertData("clientes", "NULL,'pepe', 'yes'");
        /*try {             
            Process p = Runtime.getRuntime().exec("cmd /C dir /b /s C:\\Users\\LFOM\\Desktop\\manrique\\musica\\selección musical\\house");  
            BufferedReader in = new BufferedReader(  
                                new InputStreamReader(p.getInputStream()));  
            String line = null;  
            while ((line = in.readLine()) != null) {  
                System.out.println(line);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }*/
        
    } // end of main program
    
} //End of main class of program
