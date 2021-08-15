package com.green.house.manager.greenhousemanagerservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommandRequestDto implements Serializable {

    @JsonProperty(required = true)
    private String deviceId;

    @JsonProperty(required = true)
    private List<ActionDto> actions;

}
