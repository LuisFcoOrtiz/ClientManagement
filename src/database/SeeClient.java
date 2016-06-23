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
import java.sql.ResultSetMetaData;
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
        connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/"+System.getProperty("user.name")+"/pagos.db");
        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");
        
    } //End createNewDatabase method
    
    /**     
    * Show dates from "clientes" table
    * @param  data  data what you want to see. selecting the name of the column (* for all)       
    * @return 
    * @throws java.sql.SQLException   
    */ 
    public String showClients (String data) throws SQLException {                
                        
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select "+data+" from clientes");
        //System.out.println (resultSet.first());                
        while(resultSet.next()) {
            
          // read the result set
          return (resultSet.getString(data));

        }
        //return null;
        return null;
                        
    } //End of showClients
        
    /**     
    * want one client in database
    * @param  data  data what you want to see. selecting the name of the column (* for all)   
    * @param  dataEspecific Select the especific data from the name of column in data base
    * @return 
    * @throws java.sql.SQLException   
    */ 
    public String wantClient(String data, String dataEspecific) throws SQLException {
        
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select "+data+" from clientes where nombre LIKE '"+dataEspecific+"'");
        //System.out.println (resultSet.first());                
        while(resultSet.next()) {
            
          // read the result set
          return (resultSet.getString(data));

        }
        //return null;
        return null;
    
    } //End of wantClient
    
    
    /**     
    * show number of rows in database         
     * @param dataSpecific
     * @param data
     * @return 
     * @throws java.sql.SQLException
    */    
    public String numberOfRows ( String data , String dataSpecific) throws SQLException {
        //Send a query can be update, create table, etc        
        Statement statement = connection.createStatement();
        //Set timeout to 30 sec for a query.
        statement.setQueryTimeout(30);
        //send query at all
        ResultSet rows = statement.executeQuery("SELECT COUNT(*) FROM clientes where "+data+" LIKE '"+dataSpecific+"'");
        //System.out.println(rows.getString("COUNT(*)"));
        return rows.getString("COUNT(*)");
                
    } //End of numberOfRows
    
    /**     
    * update client data, want a client and change his fields         
     * @param client name of client for update
     * @param name 
     * @param address
     * @param concept
     * @param cuote
     * @throws java.sql.SQLException
    */    
    public void updateClient (String client, String name, String address, String concept, String cuote) throws SQLException {
        //Send a query can be update, create table, etc        
        Statement statement = connection.createStatement();
        //Set timeout to 30 sec for a query.
        statement.setQueryTimeout(30);
        //update client with news params
        statement.executeUpdate("update clientes SET nombre='"+name+"', direccion='"+address+"', materia='"+concept+"', cuota='"+cuote+"' where nombre LIKE '"+client+"';");
    
    } //End of updateClient method
    
    /**     
    * drop row from a table name, where nombre of client is (clientName)
     * @param tableName     name of table
     * @param clientName    name of client to drop    
     * @throws java.sql.SQLException
    */    
    public void deleteClient (String tableName, String clientName) throws SQLException {
        //Send a query can be update, create table, etc        
        Statement statement = connection.createStatement();
        //Set timeout to 30 sec for a query.
        statement.setQueryTimeout(30);
        //drop client 
        statement.executeUpdate("DELETE FROM '"+tableName+"' WHERE nombre LIKE'"+clientName+"';");
    
    } //End of deleteClient method
    
    //*********************//
    //THIS ONLY FOR CREATE A PDF
    public void clientInPDF() throws SQLException, FileNotFoundException, DocumentException {
        
        //Query for database 
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from clientes");
        //FOR PDF
        ClientPDF clientPDF = new ClientPDF("clientes.pdf");
        //author is name of pc
        clientPDF.addAuthor(System.getProperty("user.name"));
        clientPDF.addParagraph("Lista con toda la información de los clientes");
        clientPDF.addParagraph("  ");      
        //Header of table
        clientPDF.addTable(4, 1, "NOMBRE COMPLETO", "DIRECCIÓN", "CONCEPTO", "CUOTA A PAGAR");
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
