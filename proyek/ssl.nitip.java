import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {
    public static void main(String[] args){
        String to = "got@gmail.com"; 
        String from = "akash@gmail.com"; 
        String host = "localhost"; 
        final String username = "username@gmail.com"
        final String password = "mypassword"; 
        System.out.println("TLSEmail Start");
        Properties properties = System.getProperties(); 
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465"); 
        properties.put("mail.smtp.auth", "true"); 
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");  
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("username",
                        "password");
            }
        });
        try {
            MimeMessage message = new MimeMessage(session); 
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("subject");
            message.setText("Hello, aas is sending email ");
            Transport.send(message);
            System.out.println("Yo it has been sent..");
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}