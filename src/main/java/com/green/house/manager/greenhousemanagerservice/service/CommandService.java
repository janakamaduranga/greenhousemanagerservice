package com.green.house.manager.greenhousemanagerservice.service;

import com.green.house.manager.greenhousemanagerservice.dtos.CommandRequestDto;
import com.green.house.manager.greenhousemanagerservice.dtos.CommandResponseDto;
import com.green.house.manager.greenhousemanagerservice.exception.NoRecordFoundException;
import com.green.house.manager.greenhousemanagerservice.model.Command;
import com.green.house.manager.greenhousemanagerservice.repo.CommandRepo;
import com.green.house.manager.greenhousemanagerservice.util.Mapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigInteger;
import java.util.List;

@Service
@Transactional(transactionManager = "MONGO_TXN_MGR")
@CrossOrigin
public class CommandService implements ICommandService {
    private final CommandRepo commandRepo;

    public CommandService(CommandRepo commandRepo) {
        this.commandRepo = commandRepo;
    }

    @Override
    public CommandResponseDto save(CommandRequestDto command) {
        return Mapper.getCommandResponseDto(
                commandRepo.save(Mapper.getCommandByCommandRequestDto(command)));
    }

    @Override
    public CommandResponseDto getById(Long id) {
        return Mapper.getCommandResponseDto(commandRepo.findById(BigInteger.valueOf(id)).orElse(null));
    }

    @Override
    public CommandResponseDto getUnExecutedLastCommandByDeviceId(String deviceId) {
        List<Command> commands = commandRepo.findByDeviceIdAndExecuted
                (deviceId, false, PageRequest.of(0, 1));
        if (commands != null && commands.size() > 0) {
            return Mapper.getCommandResponseDto(commands.get(0));
        }
        throw new NoRecordFoundException();
    }

    @Override
    public CommandResponseDto getUnExecutedLastCommandByDeviceIdNoException(String deviceId){
        List<Command> commands = commandRepo.findByDeviceIdAndExecuted
                (deviceId, false, PageRequest.of(0, 1));
        if (commands != null && commands.size() > 0) {
            return Mapper.getCommandResponseDto(commands.get(0));
        }
        return null;
    }

    @Override
    public CommandResponseDto findByDeviceId(String deviceId) {
        Command command = commandRepo.findByDeviceId
                (deviceId);
        if (command != null) {
            return Mapper.getCommandResponseDto(command);
        }
        throw new NoRecordFoundException();
    }
}
