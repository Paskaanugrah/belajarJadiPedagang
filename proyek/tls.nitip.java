import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
 
public class SendMail {
    public static void main(String[] args) { 
        final String username = "username@gmail.com";   
        final String password = "password";
        final String host = "localhost"; 
        Properties props = new Properties();             
        props.put("mail.smtp.auth", host);               
        props.put("mail.smtp.starttls.enable", "true");    
        props.put("mail.smtp.host", "smtp.gmail.com");     
        props.put("mail.smtp.port", "587");                
        Session session = Session.getInstance(props,new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
 
        try {
            Message message = new MimeMessage(session);    
            message.setFrom(new InternetAddress("from-email@gmail.com")); 
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("to-email@gmail.com"));
            message.setSubject("hello");
            message.setText("Yo it has been sent");
            Transport.send(message);
            System.out.println("Done");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}