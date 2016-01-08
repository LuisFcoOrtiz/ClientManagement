/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectprueba;

import clientes.ClientPDF;
import com.itextpdf.text.DocumentException;
import database.SeeClient;
import database.WorkWithDatabase;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, FileNotFoundException, DocumentException {
        
        
        //Return to Client class
        Clientes clientes = new Clientes ();
        clientes.setVisible(true);
        /*
        ClientPDF prueba = new ClientPDF("prueba.pdf");
        prueba.addAuthor("luis");
        prueba.addParagraph("esto es una prueba 4");
        prueba.addTable(10,10,"holiiiis");
        prueba.closePDF();
        */        
    } // end of main program
    
} //End of main class of program
