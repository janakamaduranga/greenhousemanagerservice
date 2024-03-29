package com.green.house.manager.greenhousemanagerservice.service;

import com.green.house.manager.greenhousemanagerservice.dtos.CommandResponseDto;
import com.green.house.manager.greenhousemanagerservice.dtos.ReadingRequestDto;
import com.green.house.manager.greenhousemanagerservice.dtos.ReadingResponseDto;
import com.green.house.manager.greenhousemanagerservice.exception.NoRecordFoundException;
import com.green.house.manager.greenhousemanagerservice.model.Command;
import com.green.house.manager.greenhousemanagerservice.model.Reading;
import com.green.house.manager.greenhousemanagerservice.repo.ReadingRepo;
import com.green.house.manager.greenhousemanagerservice.util.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigInteger;
import java.util.List;

@Slf4j
@Service
@Transactional(transactionManager = "MONGO_TXN_MGR")
@CrossOrigin
public class ReadingService implements IReadingService {
    private final ReadingRepo readingRepository;
    private final CommandService commandService;

    public ReadingService(ReadingRepo readingRepository,
                          CommandService commandService) {
        this.readingRepository = readingRepository;
        this.commandService = commandService;
    }

    @Override
    public ReadingResponseDto save(ReadingRequestDto reading) {
        return Mapper.getReadingResponseDto(
                readingRepository.save(Mapper.getReadingByReadingRequestDto(reading)));
    }

     @Override
    public CommandResponseDto saveAndReturnLatestCommand(ReadingRequestDto readingRequestDto) {

            save(readingRequestDto);
            return commandService.getUnExecutedLastCommandByDeviceIdNoException(readingRequestDto.getDeviceId());

    }

    @Override
    public ReadingResponseDto getById(Long id) {
        return Mapper.getReadingResponseDto(
                readingRepository.findById(BigInteger.valueOf(id)).orElse(null));
    }

    @Override
    public ReadingResponseDto getLastReadingByDeviceId(String deviceId) {
        Reading reading = readingRepository.findTopByDeviceIdOrderByCreatedTimeDesc(deviceId);
        CommandResponseDto commandDto = commandService.getUnExecutedLastCommandByDeviceId(deviceId);
        if (reading != null) {
            return Mapper.getReadingResponseDto(reading, commandDto);
        }
        throw new NoRecordFoundException();
    }
}
