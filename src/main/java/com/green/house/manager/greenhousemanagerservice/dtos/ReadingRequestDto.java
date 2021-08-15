package com.green.house.manager.greenhousemanagerservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReadingRequestDto implements Serializable {

    private double temperature;

    private double humidity;

    @JsonProperty(required = true)
    private String deviceId;
}
