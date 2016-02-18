/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author LFOM
 */
//This class create a new backup from pagos.db database
public class DataBaseBackUp extends Thread {
    
    //Get the actually date
    Calendar fecha = new GregorianCalendar();
    int month = fecha.get(Calendar.MONTH);
    int day = fecha.get(Calendar.DAY_OF_MONTH);
    int year = fecha.get(Calendar.YEAR);
    
    //database file
    File source = new File("C:/Users/"+System.getProperty("user.name")+"/pagos.db");
    //Database Backup in desktop with the  date of today
    File dest = new File("C:/Users/"+System.getProperty("user.name")+"/Desktop/Backup Client management "+month+"."+day+"."+year+"/pagos.db");        
    
    //Create a thread for copy pagos.db file and create a backup
    @Override
    public void run() {
                
        try {            
            FileUtils.copyFile(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        } //End try catch
        
    } //End run
    
} //ENd databasebackup 
