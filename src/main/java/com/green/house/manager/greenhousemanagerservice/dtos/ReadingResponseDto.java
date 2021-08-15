package com.green.house.manager.greenhousemanagerservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ReadingResponseDto implements Serializable {
    private double temperature;

    private double humidity;

    @JsonProperty(required = true)
    private String deviceId;
}
