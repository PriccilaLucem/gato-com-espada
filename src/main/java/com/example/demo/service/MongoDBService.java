package com.example.demo.service;

import com.mongodb.client.MongoDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoDBService {

    @Autowired
    private MongoDatabase mongoDatabase;

    public MongoDBService(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    public void printDatabaseName() {
        System.out.println("Database Name: " + mongoDatabase.getName());
    }
}
