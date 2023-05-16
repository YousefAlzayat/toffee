import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Session;
import javax.mail.Transport;
import javax.activation.*;

public class SendEmail
{
 
   public void send(String recipient, String OTP)
   {   
      // email ID of  Sender.
      String sender = "";

      // Getting system properties
      Properties properties = new Properties();
 
      properties.put("mail.smtp.host", "smtp.gmail.com");
      properties.put("mail.smtp.port", "587");
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.starttls.enable", "true");
      
      Authenticator auth = new Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication("", "");
         }
      };

      // creating session object to get properties
      Session session = Session.getInstance(properties, auth);
 
      try
      {
         // MimeMessage object.
         MimeMessage message = new MimeMessage(session);
 
         // Set From Field: adding senders email to from field.
         message.setFrom(new InternetAddress(sender));
 
         // Set To Field: adding recipient's email to from field.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
 
         // Set Subject: subject of the email
         message.setSubject("Toffee: OTP Request");
 
         // set body of the email.
         message.setText("Hi, \n\n\n Here is the OTP you have requested: " + OTP);
 
         // Send email.
         Transport.send(message);
      }
      catch (MessagingException mex)
      {
         mex.printStackTrace();
      }
   }
}
