package com.green.house.manager.greenhousemanagerservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
 public class TransactionConfig extends AbstractMongoClientConfiguration {
    @Value("${spring.data.mongodb.database}")
    private String dataBaseName;

    @Override
    protected String getDatabaseName() {
        return dataBaseName;
    }

    @Bean(name = "MONGO_TXN_MGR")
    public MongoTransactionManager transactionManager(MongoDatabaseFactory factory){
        return new MongoTransactionManager(factory);
    }
}
