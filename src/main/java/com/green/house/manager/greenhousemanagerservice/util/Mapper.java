package com.green.house.manager.greenhousemanagerservice.util;

import com.green.house.manager.greenhousemanagerservice.dtos.*;
import com.green.house.manager.greenhousemanagerservice.model.*;

import java.util.stream.Collectors;

public class Mapper {
    private Mapper() {

    }

    public static ReadingResponseDto getReadingResponseDto(Reading reading) {
        ReadingResponseDto readingResponseDto = new ReadingResponseDto();

        readingResponseDto.setDeviceId(reading.getDeviceId());
        readingResponseDto.setHumidity(reading.getHumidity());

        return readingResponseDto;
    }

    public static CommandResponseDto getCommandResponseDto(Command command) {
        CommandResponseDto commandResponseDto = new CommandResponseDto();

        commandResponseDto.setDeviceId(command.getDeviceId());
        commandResponseDto.setActions(command.getActions() != null ? command.getActions().stream()
                .map(Mapper::getActionDto)
                .collect(Collectors.toList()) : null
        );

        return commandResponseDto;
    }

    private static Action getAction(ActionDto actionDto) {
        Action action = new Action();
        action.setDevice(Devices.getDeviceByIdentifier(actionDto.getDevice()).orElse(null));
        action.setActionEum(ActionEum.getActionById(actionDto.getAction()).orElse(null));
        return action;
    }

    private static ActionDto getActionDto(Action action) {
        ActionDto actionDto = new ActionDto();
        actionDto.setAction(action.getActionEum() != null ? action.getActionEum().getId() : -1);
        actionDto.setDevice(action.getDevice() != null ? action.getDevice().getDeviceIdentifier() : null);
        return actionDto;
    }

    public static Reading getReadingByReadingRequestDto(ReadingRequestDto readingRequestDto) {
        Reading reading = new Reading();

        reading.setDeviceId(readingRequestDto.getDeviceId());
        reading.setHumidity(readingRequestDto.getHumidity());
        reading.setTemperature(readingRequestDto.getTemperature());

        return reading;
    }

    public static Command getCommandByCommandRequestDto(CommandRequestDto commandRequestDto) {
        Command command = new Command();

        command.setDeviceId(commandRequestDto.getDeviceId());
        command.setActions(
                commandRequestDto.getActions() != null
                        ? commandRequestDto.getActions().stream()
                        .map(actionDto -> getAction(actionDto))
                        .collect(Collectors.toList()) : null
        );

        return command;
    }
}
