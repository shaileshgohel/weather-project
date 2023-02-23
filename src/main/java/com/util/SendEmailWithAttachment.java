package com.util;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmailWithAttachment {

  public void sendAnEmail() {

    // SMTP server properties
    String smtpHost = "smtp.gmail.com";
    String smtpPort = "587";
    final String email = "youremail@gmail.com";
    final String password = "your_passwor";

    // Recipient email address
    String to = "shailthesweeter@gmail.com";

    // Email subject and message
    String subject = "Test email with ZIP attachment";
    String message = "Please find attached the ZIP file.";

    // ZIP file to be attached
    String zipFilePath = "C:\\Users\\shailesh.gohel\\Documents\\Shailesh\\Appium\\Eclipse_Workspace\\weather-project\\InputData\\20230223_005527\\ZipOfAllExcel.zip";

    // Set up properties for mail server
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", smtpHost);
    props.put("mail.smtp.port", smtpPort);

    // Create a new session with authentication
    Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(email, password);
        }
      });

    try {
      // Create a new message
      Message msg = new MimeMessage(session);

      // Set the sender and recipient addresses
      msg.setFrom(new InternetAddress(email));
      msg.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse(to));

      // Set the subject and message body
      msg.setSubject(subject);

      // Create the message body part for text
      MimeBodyPart messageBodyPart = new MimeBodyPart();
      messageBodyPart.setText(message);

      // Create the message body part for ZIP attachment
      MimeBodyPart attachmentPart = new MimeBodyPart();
      DataSource source = new FileDataSource(zipFilePath);
      attachmentPart.setDataHandler(new DataHandler(source));
      attachmentPart.setFileName("file.zip");

      // Add the message body parts to a multipart message
      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(messageBodyPart);
      multipart.addBodyPart(attachmentPart);

      // Set the multipart message as the message's content
      msg.setContent(multipart);

      // Send the message
      Transport.send(msg);

      System.out.println("Email with attachment sent successfully.");

    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }
}

