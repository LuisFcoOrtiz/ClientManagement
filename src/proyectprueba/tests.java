/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectprueba;

import database.CryptoException;
import database.CryptoUtils;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.IllegalBlockSizeException;

/**
 *
 * @author LFOM
 */
public class tests {
    
    public static void main(String[] args) {
        
        File inputFile = new File("C:/Users/"+System.getProperty("user.name")+"/pagos.db");
        File encryptedFile = new File("C:/Users/"+System.getProperty("user.name")+"/pagos.db");
        File decryptedFile = new File("C:/Users/"+System.getProperty("user.name")+"/pagos.db");
         
        try {
            //CryptoUtils.encrypt( inputFile, encryptedFile);
            CryptoUtils.decrypt( encryptedFile, decryptedFile);
        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(tests.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(tests.class.getName()).log(Level.SEVERE, null, ex);
        } // End try catch
        
    } // End main
    
} //End class test  
