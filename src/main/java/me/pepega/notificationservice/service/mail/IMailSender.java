package me.pepega.notificationservice.service.mail;

public interface IMailSender {
    void sendMail(String to, String subject, String text);
}
