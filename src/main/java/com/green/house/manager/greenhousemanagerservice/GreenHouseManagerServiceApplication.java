package com.green.house.manager.greenhousemanagerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"com.green.house.manager.greenhousemanagerservice.repo"})
public class GreenHouseManagerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreenHouseManagerServiceApplication.class, args);
    }

}
