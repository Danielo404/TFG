package Mailer;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class mailerUtils {
	public void enviar(String TO, String asunto, String mensaje) {

        String host;
        String port;
        MimeMessage Mimessage;
        MailSSLSocketFactory sf;
        Properties properties;
        Session session;
        final String mail = "declive.ev@gmail.com";
        final String password = "#&6X2^^37bsa^8%cu*o&X9#8";

        host = "smtp.gmail.com";
        port = "25";
        properties = System.getProperties();

        try {
            sf = new MailSSLSocketFactory();

            sf.setTrustAllHosts(true);

            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", port);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);
            properties.put("mail.smtp.starttls.enable","true");
            session = Session.getInstance(properties, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(mail, password);
                }
            });

            session.setDebug(true);
            
            Mimessage = new MimeMessage(session);
            
            Mimessage.setFrom(new InternetAddress(mail));
            Mimessage.addRecipient(Message.RecipientType.TO, new InternetAddress(TO));
            Mimessage.setSubject(asunto);
            Mimessage.setText(mensaje);
            Transport.send(Mimessage);
            
            
        } catch (GeneralSecurityException e) {
        
            e.printStackTrace();
        } catch (AddressException e) {
            
            e.printStackTrace();
        } catch (MessagingException e) {
        
            e.printStackTrace();
        }

    }
}
