package com.selvigtech.blog.service;

import com.selvigtech.blog.exception.EmailFailException;
import com.selvigtech.blog.model.LocalUser;
import com.selvigtech.blog.model.VerificationToken;
import com.selvigtech.blog.model.dao.VerificationTokenDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${email.from}")
    private String fromAddress;
    @Value("${app.frontend.url}")
    private String url;
    private JavaMailSender javaMailSender;
    private VerificationTokenDAO verificationTokenDAO;

    public EmailService(JavaMailSender javaMailSender, VerificationTokenDAO verificationTokenDAO) {
        this.javaMailSender = javaMailSender;
        this.verificationTokenDAO = verificationTokenDAO;
    }

    private SimpleMailMessage makeMailMessage() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromAddress);
        return simpleMailMessage;
    }

    public void sendVerificationEmail(VerificationToken verificationToken) throws EmailFailException {
        SimpleMailMessage message = makeMailMessage();
        message.setTo(verificationToken.getUser().getEmail());
        message.setSubject("Verify your email to activate your account.");
        message.setText("Click the link below to verify your account.\n" +
                url + "/auth/verify?token=" + verificationToken.getToken());

        try {
            javaMailSender.send(message);
        } catch (MailException ex) {
            throw new EmailFailException();
        }
    }

    public void sendPasswordResetEmail(LocalUser user, String token) throws EmailFailException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Password reset link");
        message.setText("You requested a password reset link from our account on our website. Please " +
                "click the link below to reset your password.\n" + url + "/auth/reset?token=" + token);
        try {
            javaMailSender.send(message);
        } catch (MailException ex) {
            throw new EmailFailException();
        }
    }
}
