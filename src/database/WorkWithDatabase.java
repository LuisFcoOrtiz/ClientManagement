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


/**
 * Class used for create a new Data base with Sqlite and work with it
 * @author LFOM
 */
//Class used for create a new Data base with Sqlite
public class WorkWithDatabase {    
    
    //new object connection for all the class
    Connection connection = null;
    
    /**     
    * Create a new database in root filesystem. and work with it 
    * @param  dataBaseName  name of database.           
    */    
    public void createNewDatabase(String dataBaseName) throws SQLException, ClassNotFoundException {                
        
        // Create a new database. With name of database in parameter
        //Name and path of new database. 
        connection = DriverManager.getConnection("jdbc:sqlite:"+dataBaseName);
        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");
        
    } //End createNewDatabase method
    
    
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
    public void showDatabase(String dates, String tableName) throws SQLException {
    
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select "+dates+" from "+tableName+"");
        //System.out.println (resultSet.first());
        while(resultSet.next()) {
          // read the result set
          System.out.println("name = " + resultSet.getString("name"));
          System.out.println("id = " + resultSet.getInt("id"));
        }
        
    } //End of showDatabase
        
    
} //End of Class WorkWithDatabase
