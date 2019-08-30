/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Ramiro
 */
public class EmailDelegate {

    private static final String SMTP_HOST_NAME = "smtp-relay.gmail.com"; //smtp URL
    private static final int SMTP_HOST_PORT = 25; //port number
    public static final String EMAIL = "notificacion@clinicadelcountry.com";
    public static final String PASSWORD = "Cdc18092013";

    //  public static final String mails = "abenitez@clinicadelcountry.com";
    //nmacaya@clinicadelcountry.com,cgonzalez@clinicadelcountry.com,jospina@clinicadelcountry.com,cvelasco@clinicadelcountry.com,acorrea@clinicadelcountry.com,lgomez@clinicadelcountry.com,avelasquez@clinicadelcountry.com,//
    
    public static final long TIEMPO_SEGUNDOS_VERIFICAR_HORA = 20;

    public static String sendMailViaGodaddy(final List<String> to, final String subject, final String text) {
        String resultado = "";

        String destinos = "";
        for (int i = 0; i < to.size(); i++) {
            destinos = destinos + to.get(i) + (i == to.size() ? "" : ",");
        }

        resultado = "";

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean enviado = sendMail(to, subject, text);
                while (!enviado) {
                    try {
                        Thread.sleep(20000);
                        enviado = sendMail(to, subject, text);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EmailDelegate.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        t.start();
        return resultado;

    }

    public static boolean sendMail(List<String> to, String subject, String text) {
        try {
            Properties props = System.getProperties();
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.host", SMTP_HOST_NAME);
            props.put("mail.smtp.starttls.enable", "true");
            //  props.put("mail.smtp.ssl.trust", SMTP_HOST_NAME);
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "true");
            props.put("mail.smtp.ehlo", "false");
            props.setProperty("mail.user", EMAIL);
            props.setProperty("mail.password", PASSWORD);
            props.put("mail.smtp.port", SMTP_HOST_PORT);
       //     props.put("mail.smtp.socketFactory.port", SMTP_HOST_PORT);
//props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//props.put("mail.smtp.socketFactory.fallback", "false");
            // Session mailSession = Session.getDefaultInstance(props, null);

            Session mailSession = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(EMAIL, PASSWORD);
                        }
                    });

            MimeMessage message = new MimeMessage(mailSession);
            message.setSentDate(new java.util.Date());
            message.setSubject(subject);
            message.setFrom(new InternetAddress(EMAIL));
            message.setContent(text, "text/html");

            for (String to1 : to) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to1));
            }
            Transport transport = mailSession.getTransport();
            transport.connect(SMTP_HOST_NAME, SMTP_HOST_PORT, EMAIL, PASSWORD);
            transport.sendMessage(message,
                    message.getRecipients(Message.RecipientType.TO));
            transport.close();
            return true;
        } catch (Exception ex) {
            System.err.println(ex.toString());
            return false;
        }

    }

    public static int strToInt(String txt) {
        try {
            return Integer.parseInt(txt);
        } catch (Exception ex) {
            return -1;
        }
    }

}
