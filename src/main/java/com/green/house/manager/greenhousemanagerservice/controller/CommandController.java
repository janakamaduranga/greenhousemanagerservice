package com.green.house.manager.greenhousemanagerservice.controller;

import com.green.house.manager.greenhousemanagerservice.dtos.CommandRequestDto;
import com.green.house.manager.greenhousemanagerservice.dtos.CommandResponseDto;
import com.green.house.manager.greenhousemanagerservice.model.ActionEum;
import com.green.house.manager.greenhousemanagerservice.model.Devices;
import com.green.house.manager.greenhousemanagerservice.service.CommandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class CommandController {

    private final CommandService commandService;

    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping(value = "user/commands", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> saveCommand(CommandRequestDto commandRequestDto) {
        isValid(commandRequestDto);
        commandService.save(commandRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "device/commands/{deviceId}")
    public ResponseEntity<CommandResponseDto> findByDeviceId(@PathVariable(required = true) String deviceId) {
        return new ResponseEntity<>(commandService.getUnExecutedLastCommandByDeviceId(deviceId),
                HttpStatus.OK);

    }

    private boolean isValid(CommandRequestDto commandRequestDto) {
        if (Objects.isNull(commandRequestDto.getActions())) {
            throw new IllegalArgumentException("actions can not be null");
        }
        commandRequestDto.getActions().forEach(actionDto -> {
            Devices.getDeviceByIdentifier(actionDto.getDevice())
                    .orElseThrow(() -> new IllegalArgumentException("Device is null"));
            ActionEum.getActionById(actionDto.getAction())
                    .orElseThrow(() -> new IllegalArgumentException(("Action is empty")));
        });
        return true;
    }
}
