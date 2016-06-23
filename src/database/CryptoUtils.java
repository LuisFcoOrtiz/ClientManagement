/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
 
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
 

/**
 *
 * @author LFOM
 * This class encrypt the database when the program is close
 * and decrypt the database when the program is running
 */
public class CryptoUtils {
    
    //Encryption algorithm AES
    // AES algorithm requires that the key size must be 16 bytes
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
        
    //encrypt the database
    public static void encrypt(File inputFile, File outputFile)
        throws CryptoException, NoSuchAlgorithmException, IllegalBlockSizeException {
        doCrypto(Cipher.ENCRYPT_MODE, "cannot  decrypts", inputFile, outputFile);
    }
    
    //Decrypt the database
    public static void decrypt(File inputFile, File outputFile)
            throws CryptoException, NoSuchAlgorithmException, IllegalBlockSizeException {
        doCrypto(Cipher.DECRYPT_MODE, "cannot  decrypts", inputFile, outputFile);
    }
 
    private static void doCrypto(int cipherMode, String key, File inputFile,
            File outputFile) throws CryptoException, NoSuchAlgorithmException, IllegalBlockSizeException {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);
             
            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);
             
            byte[] outputBytes = cipher.doFinal(inputBytes);
             
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);
             
            inputStream.close();
            outputStream.close();
             
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex) {
            throw new CryptoException("Error encrypting/decrypting file", ex);
        }
    }
    
} //End class
