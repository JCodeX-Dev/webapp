package dev.jcodex.webapp.service;

import dev.jcodex.webapp.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final String mailTemplate = "***********************************************\n" +
            "Mail from %s (%s)\n" +
            "***********************************************\n\n%s";
    @Autowired
    private JavaMailSender mailSender;
    @Value("${mailTo}")
    private String mailTo;
    @Value("${mailFrom}")
    private String mailFrom;

    public boolean sendMessage(Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailFrom);
        message.setTo(mailTo);
        message.setReplyTo(mail.getEmail());
        message.setSubject(mail.getSubject());
        String text = String.format(mailTemplate, mail.getName(), mail.getEmail(), mail.getMessage());
        message.setText(text);
        try {
            mailSender.send(message);
            return true;
        } catch (MailException me) {
            System.out.println(me);
            return false;
        }

    }
}
