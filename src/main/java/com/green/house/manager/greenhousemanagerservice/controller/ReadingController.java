package com.green.house.manager.greenhousemanagerservice.controller;

import com.green.house.manager.greenhousemanagerservice.dtos.CommandResponseDto;
import com.green.house.manager.greenhousemanagerservice.dtos.ReadingRequestDto;
import com.green.house.manager.greenhousemanagerservice.dtos.ReadingResponseDto;
import com.green.house.manager.greenhousemanagerservice.service.CommandService;
import com.green.house.manager.greenhousemanagerservice.service.ReadingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class ReadingController {
    private final ReadingService readingService;
    private final CommandService commandService;

    public ReadingController(ReadingService readingService,
                             CommandService commandService) {
        this.readingService = readingService;
        this.commandService = commandService;
    }

    @PostMapping(value = "device/readings", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CommandResponseDto> saveReading(ReadingRequestDto readingRequestDto) {

        return new ResponseEntity<>(readingService.saveAndReturnLatestCommand(readingRequestDto),
                HttpStatus.CREATED);
    }

    @GetMapping(value = "user/readings/{deviceId}")
    public ResponseEntity<ReadingResponseDto> getById(@PathVariable(value = "deviceId") String deviceId) {
        return new ResponseEntity<>(readingService.getLastReadingByDeviceId(deviceId),
                HttpStatus.OK);
    }
}
