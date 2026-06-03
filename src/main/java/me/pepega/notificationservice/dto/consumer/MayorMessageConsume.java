package me.pepega.notificationservice.dto.consumer;

import lombok.Data;

import java.util.List;

@Data
public class MayorMessageConsume {
    private List<String> mayorsEmails;
    private String userIdentifier;
    private String userEmail;
    private String appeal;
    private Long appealId;
}
