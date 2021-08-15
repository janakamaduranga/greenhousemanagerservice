package com.green.house.manager.greenhousemanagerservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Document("command")
public class Command {
    @Transient
    public static final String SEQUENCE_NAME = "command_sequence";

    @Id
    private BigInteger id;
    private String deviceId;
    private List<Action> actions;
    private boolean executed;
    private Instant createdDateTime = Instant.now();
    private Instant updatedDateTime = Instant.now();
}
