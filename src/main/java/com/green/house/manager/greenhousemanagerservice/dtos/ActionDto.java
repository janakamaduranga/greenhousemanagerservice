package com.green.house.manager.greenhousemanagerservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ActionDto implements Serializable {
    @JsonProperty(required = true)
    private String device;

    @JsonProperty(required = true)
    private int action;
}
