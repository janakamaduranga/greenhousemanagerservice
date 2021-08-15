package com.green.house.manager.greenhousemanagerservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.time.Instant;

@Getter
@Setter
@Document("reading")
@NoArgsConstructor
@AllArgsConstructor
public class Reading {
    @Transient
    public static final String SEQUENCE_NAME = "reading_sequence";

    @Id
    private BigInteger id;
    private double temperature;
    private double humidity;
    private Instant createdTime = Instant.now();
    private String deviceId;
}
