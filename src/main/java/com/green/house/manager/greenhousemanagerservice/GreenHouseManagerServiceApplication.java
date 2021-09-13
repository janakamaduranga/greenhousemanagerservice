package com.green.house.manager.greenhousemanagerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"com.green.house.manager.greenhousemanagerservice.repo"})
@EnableEurekaClient
public class GreenHouseManagerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreenHouseManagerServiceApplication.class, args);
    }

}
