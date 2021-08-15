package com.green.house.manager.greenhousemanagerservice.repo;

import com.green.house.manager.greenhousemanagerservice.model.Command;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface CommandRepo extends MongoRepository<Command, BigInteger> {
    @Query(value = "{$and:[{deviceId:?0},{executed:?1}]}", sort = "{createdDateTime:-1}")
    List<Command> findByDeviceIdAndExecuted
            (String deviceId, Boolean executed, Pageable pageable);

    Command findByDeviceId(String deviceId);
}
