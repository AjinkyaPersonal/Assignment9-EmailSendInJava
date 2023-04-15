package org.geekster;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class HandleMail {
    void sendMail(){
        String host = "smtp.gmail.com";

        Properties prop = System.getProperties();
        System.out.println(prop);

        prop.put("mail.smtp.host" , host);
        prop.put("mail.smtp.port" , "465");
        prop.put("mail.smtp.ssl.enable" , "true");
        prop.put("mail.smtp.auth" , "true");
//        Creating session
        Session session = Session.getInstance(prop, new MailAuthenticator()) ;
//        Create the message object
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(MailConstants.SENDER);
            for(String receiver : MailConstants.RECEIVER){
//                To multiple receipients
                mimeMessage.addRecipient(Message.RecipientType.TO , new InternetAddress(receiver));
                System.out.println(receiver);
            }
//            To single receipient
//            mimeMessage.setRecipient(Message.RecipientType.TO , new InternetAddress(MailConstants.RECEIVER));
            mimeMessage.setSubject(MailConstants.SUBJECT);

            mimeMessage.setText(MailConstants.MESSAGE);
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
