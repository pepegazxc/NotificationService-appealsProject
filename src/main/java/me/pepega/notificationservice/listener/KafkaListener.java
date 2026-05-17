package me.pepega.notificationservice.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.pepega.notificationservice.dto.consumer.*;
import me.pepega.notificationservice.service.mail.MailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaListener {

    @Value("${app.url}")
    private String appUrl;
    @Value("${mail.main}")
    private String mainMail;

    private final MailService mail;

    @org.springframework.kafka.annotation.KafkaListener(topics = "user-registered", groupId = "notification-service")
    public void registrationListener(@Payload RegistrationConsume consume){
        log.info("Registration event for {}", consume.getEmail());

        String link = appUrl + "/mail/confirm?token=" + consume.getToken();

        mail.sendMail(
                consume.getEmail(),
                "Mail confirmation",
                "Please use this link for confirm your mail: " + link
        );
    }

    @org.springframework.kafka.annotation.KafkaListener(topics = "admin-request", groupId = "notification-service")
    public void adminRequestListener(@Payload AdminRequestConsume consume){
        log.info("Admin request event, token: {}", consume.getToken());

        String link = appUrl + "/admin/request?token=" + consume.getToken();
        mail.sendMail(
                mainMail,
                "Admin confirmation",
                "Use this link confirm or reject admin: " + link
        );
    }

    @org.springframework.kafka.annotation.KafkaListener(topics = "mayor-request", groupId = "notification-service")
    public void mayorRequestListener(@Payload MayorRequestConsume consume){
        log.info("Message about mayor request to admin {}", consume.getEmail());

        String link = appUrl + "/mayor/request?token=" + consume.getToken();
        mail.sendMail(
                consume.getEmail(),
                "Mayor confirmation",
                "Use this link to confirm or reject the mayor request: " + link
        );
    }

    @org.springframework.kafka.annotation.KafkaListener(topics = "request-response", groupId = "notification-service")
    public void requestResultsListener(@Payload RequestResultConsume consume){
        log.info("Role request result for {}", consume.getEmail());

        mail.sendMail(
                consume.getEmail(),
                "Role request results",
                consume.getMessage()
        );
    }

    @org.springframework.kafka.annotation.KafkaListener(topics = "user-logged", groupId = "notification-service")
    public void userLoggedListener(@Payload LoggedConsume consume){
        log.info("Logged event by {}", consume.getEmail());
        mail.sendMail(
                consume.getEmail(),
                "Successful login",
                "Successful login was made. Time: " + consume.getTime()
        );
    }

}
