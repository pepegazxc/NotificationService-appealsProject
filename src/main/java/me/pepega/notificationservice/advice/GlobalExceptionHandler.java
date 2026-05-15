package me.pepega.notificationservice.advice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.pepega.notificationservice.dto.response.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSendException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final FactoryException factory;

    @ExceptionHandler(MailSendException.class)
    public ResponseEntity<ExceptionResponse> handeMailSend(MailSendException ex){
        log.error("Mail sending failed", ex);
        return factory.build(
                INTERNAL_SERVER_ERROR,
                "Something went wrong while mail sending"
        );
    }
}
