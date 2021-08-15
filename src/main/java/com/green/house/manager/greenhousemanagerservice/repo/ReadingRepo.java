package com.green.house.manager.greenhousemanagerservice.repo;

import com.green.house.manager.greenhousemanagerservice.model.Reading;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ReadingRepo extends MongoRepository<Reading, BigInteger> {
    Reading findTopByDeviceIdOrderByCreatedTimeDesc(String deviceId);
}
