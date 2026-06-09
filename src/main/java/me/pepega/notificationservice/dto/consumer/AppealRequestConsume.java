package me.pepega.notificationservice.dto.consumer;

import lombok.Data;
import me.pepega.notificationservice.dto.enums.Status;

@Data
public class AppealRequestConsume {
    private String userEmail;
    private String appealResponse;
    private Status status;
}
