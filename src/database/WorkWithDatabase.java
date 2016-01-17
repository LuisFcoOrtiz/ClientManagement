/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Class used for create a new Data base with Sqlite and work with it
 * @author LFOM
 */
//Class used for create a new Data base with Sqlite
public class WorkWithDatabase extends Thread {    
    
    //new object connection for all the class
    Connection connection = null;            
    
    @Override
    public void run() {
        try {
            // Create a new database. With name of database in parameter
            //Name and path of new database. in user folder
            connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/"+System.getProperty("user.name")+"/pagos.db");
            // load the sqlite-JDBC driver using the current class loader
            Class.forName("org.sqlite.JDBC");

            /*CREATE THE MAIN TABLE CLIENTES FOR WORK WITH IT*/
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS`clientes` (\n" +
                    "	`ID`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                    "	`nombre`	TEXT NOT NULL,\n" +
                    "	`direccion`	TEXT NOT NULL,\n" +
                    "	`materia`	TEXT NOT NULL,\n" +
                    "	`cuota`	INTEGER NOT NULL\n" +
                    ")");
        } catch (SQLException ex) {
            Logger.getLogger(WorkWithDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WorkWithDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }            
    
    /**     
    * Send a query with for a database 
    * @param  query  send query String          
    */    
    public void sendQuery (String query) throws SQLException {
        //Send a query can be update, create table, etc        
        Statement statement = connection.createStatement();
        //Set timeout to 30 sec for a query.
        statement.setQueryTimeout(30);
        //send query at all
        statement.executeUpdate(query);
    
    } //End of sendQuery method
    
    /**     
    * Insert data into the database sending a query
    * @param  tableName  name of table for create a new table      
    * @param  columns   Name of columns and datatypes (INT, TEXT, CHAR, VARCHAR) 
    */    
    public void createTable (String tableName, String columns) throws SQLException {
        //Send a query can be update, create table, etc        
        Statement statement = connection.createStatement();
        //Set timeout to 30 sec for a query.
        statement.setQueryTimeout(30);
        //Create a new table with parameters
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS "+tableName+"(" +
        columns+
        ");");
    
    } //End CreateTable method
    
    /**     
    * Insert data into the database sending a query
    * @param  tableName  name of table for send a query.           
    * @param  values    values for the table. Uses ("") for the values and separate with (,)    
    */    
    public void InsertData (String tableName, String values) throws SQLException {
        //Send a query can be update, create table, etc        
        Statement statement = connection.createStatement();
        //Set timeout to 30 sec for a query.
        statement.setQueryTimeout(30);
        //send a query with tableName and values parameters. (values need "" because its a String)
        statement.executeUpdate("INSERT INTO "+tableName+" VALUES ("+values+");");
    
    } //End of InsertData method
    
    /**     
    * Show dates from table selecting the table name
    * @param  dates  data what you want to see. selecting the name of the column (* for all)
    * @param  tableName select the table for see his content   
    * @throws java.sql.SQLException   
    */ 
    public void showData (String dates, String tableName) throws SQLException {
    
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select "+dates+" from "+tableName+"");
        //System.out.println (resultSet.first());
        while(resultSet.next()) {
          // read the result set
          System.out.println("name = " + resultSet.getString("nombre"));
          System.out.println("Direccion = " + resultSet.getInt("direccion"));
          System.out.println("materia = " + resultSet.getInt("materia"));
        }
        
    } //End of showDatabase
    
    /****************/
    //add new client only use for table CLIENT
    public void newClient (String nombre, String direccion, String materia, Integer cuota) throws SQLException {
              
        Statement statement = connection.createStatement();
        //Set timeout to 30 sec for a query.
        statement.setQueryTimeout(30);
        //add new client
        statement.executeUpdate("INSERT INTO clientes VALUES (NULL,'"+nombre+"','"+direccion+"','"+materia+"',"+cuota+");");
        
    } //End newClient    
    
} //End of Class WorkWithDatabase
