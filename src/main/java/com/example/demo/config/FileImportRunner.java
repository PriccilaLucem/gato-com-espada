package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.service.FileDataService;

@Component
public class FileImportRunner implements CommandLineRunner {

    @Autowired
    private FileDataService fileDataService;

    @Override
    public void run(String... args) throws Exception {
        String filePath = "enemy.json";
        fileDataService.readAndSaveDataFromFile(filePath);
    }
}
