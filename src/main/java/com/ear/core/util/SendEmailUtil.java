package com.ear.core.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailUtil {
 
	final String username = "elialvarezromero11@gmail.com";
    final String password = "hbfecgsuyrgjxvzu";

    public void sendEmailCreateUser(String subject, String text, String email) {
    	
    	 Properties prop = new Properties();
 		 prop.put("mail.smtp.host", "smtp.gmail.com");
         prop.put("mail.smtp.port", "465");
         prop.put("mail.smtp.auth", "true");
         prop.put("mail.smtp.socketFactory.port", "465");
         prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
         
         Session session = Session.getInstance(prop,
                 new javax.mail.Authenticator() {
                     protected PasswordAuthentication getPasswordAuthentication() {
                         return new PasswordAuthentication(username, password);
                     }
                 });

         try {

             Message message = new MimeMessage(session);
             message.setFrom(new InternetAddress(username));
             message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));
             
             message.setSubject(subject);
             message.setText(text);

             Transport.send(message);

         } catch (MessagingException e) {
             e.printStackTrace();
         }
        
    }
    
}
