package com.green.house.manager.greenhousemanagerservice.service;

import com.green.house.manager.greenhousemanagerservice.dtos.CommandRequestDto;
import com.green.house.manager.greenhousemanagerservice.dtos.CommandResponseDto;

public interface ICommandService {
    CommandResponseDto save(CommandRequestDto command);

    CommandResponseDto getById(Long id);

    CommandResponseDto getUnExecutedLastCommandByDeviceId(String deviceId);

    CommandResponseDto findByDeviceId(String deviceId);
}
