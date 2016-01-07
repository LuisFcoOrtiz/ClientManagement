/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import clientes.ClientPDF;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
/**
 *
 * @author LFOM
 */
    /*
    This class is only for see the client in database
    */

public class SeeClient {    
    
    //new object connection for all the class
    Connection connection = null;
    
    /**     
    * Create a new database in DB/pagos.db. and work with it
    * ONLY IN DB/pagos.db path
    */    
    public void createNewDatabase() throws SQLException, ClassNotFoundException {                
        
        // Create a new database. With name of database in parameter
        //Name and path of new database. 
        connection = DriverManager.getConnection("jdbc:sqlite:DB/pagos.db");
        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");
        
    } //End createNewDatabase method
    
    /**     
    * Show dates from "clientes" table
    * @param  data  data what you want to see. selecting the name of the column (* for all)   
    * @param  dataEspecific Select the especific data from the name of column in data base
    * @return 
    * @throws java.sql.SQLException   
    */ 
    public String showClients (String data, String dataEspecific) throws SQLException {                
        
        
        
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select "+data+" from clientes");
        //System.out.println (resultSet.first());                
        while(resultSet.next()) {
            
          // read the result set
          System.out.println("name = " + resultSet.getString(dataEspecific));
          return ("name = " + resultSet.getString(dataEspecific));
          
          
        }
        //return null;
        return "holis";
                
    } //End of showClients
    
    /**     
    * show number of rows in database         
    */    
    public void numberOfRows () throws SQLException {
        //Send a query can be update, create table, etc        
        Statement statement = connection.createStatement();
        //Set timeout to 30 sec for a query.
        statement.setQueryTimeout(30);
        //send query at all
        ResultSet rows = statement.executeQuery("SELECT COUNT(*) FROM clientes");
        System.out.println(rows.getString("COUNT(*)"));
        
    } //End of numberOfRows
    
    //*********************//
    //THIS ONLY FOR CREATE A PDF
    public void clientInPDF() throws SQLException, FileNotFoundException, DocumentException {
        
        //Query for database 
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from clientes");
        //FOR PDF
        ClientPDF clientPDF = new ClientPDF("clientes.pdf");
        clientPDF.addAuthor("Administrador empresa");
        clientPDF.addParagraph("Lista con toda la información de los clientes");
        clientPDF.addParagraph("");
        //Header of table
        clientPDF.addTable(4, 1, "NOMBRE COMPLETO", "DIRECCIÓN", "MATERIA", "CUOTA A PAGAR");
        //result for database in table for PDF
        while(resultSet.next()) {
          
            //4 numbers of columns and 1 number of row for each client
          clientPDF.addTable(4, 1, resultSet.getString("nombre"), resultSet.getString("direccion"), resultSet.getString("materia"), resultSet.getString("cuota")+" €" );          
          
        } //End while
        
        //End the PDF document
        clientPDF.closePDF();
    } //End clientPDF ONLY FOR PDF CLIENT
    //*********************//
    
} //End of SeeClient class
