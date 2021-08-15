package com.green.house.manager.greenhousemanagerservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class CommandResponseDto implements Serializable {
    @JsonProperty(required = true)
    private String deviceId;

    @JsonProperty(required = true)
    private List<ActionDto> actions;
}
