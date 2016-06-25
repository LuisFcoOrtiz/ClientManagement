/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author LFOM
 * Class for send a Email to clients
 */
public class SendEmail {        
       
    //Email and pass from server
    final String username = "client.management.notifier@gmail.com";
    final String password = "YlIXaMMfSkav9RSN5Cu5";
    
    /**
    *send email to client
    * @param clientEmail email to send 
     * @param subjectClient subject for client
     * @param messageClient message for client
    *
    */
    public void send(String clientEmail, String subjectClient, String messageClient) {
        
        //properties (protocol, port, etc)
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        //Start session
        Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
              protected PasswordAuthentication getPasswordAuthentication() {
                      return new PasswordAuthentication(username, password);
              }
        });
        
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from-email@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(clientEmail)); //Client email            
            message.setSubject(subjectClient);
            message.setText(messageClient);

            Transport.send(message);

            System.out.println("Done");
            
        } catch (MessagingException e) {
                throw new RuntimeException(e);
        } //End try catch
        
    } //End send function		
						  
} //end class
