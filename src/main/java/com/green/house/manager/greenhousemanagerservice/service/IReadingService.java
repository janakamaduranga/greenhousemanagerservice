package com.green.house.manager.greenhousemanagerservice.service;

import com.green.house.manager.greenhousemanagerservice.dtos.CommandResponseDto;
import com.green.house.manager.greenhousemanagerservice.dtos.ReadingRequestDto;
import com.green.house.manager.greenhousemanagerservice.dtos.ReadingResponseDto;

public interface IReadingService {
    ReadingResponseDto save(ReadingRequestDto command);

    CommandResponseDto saveAndReturnLatestCommand(ReadingRequestDto command);


    ReadingResponseDto getById(Long id);

    ReadingResponseDto getLastReadingByDeviceId(String deviceId);
}
