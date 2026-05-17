package me.pepega.notificationservice.dto.consumer;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoggedConsume {
    private String email;
    private LocalDateTime time;
}
