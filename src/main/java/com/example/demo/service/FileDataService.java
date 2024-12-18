package com.example.demo.service;

import com.example.demo.models.enemy.EnemiesModel;
import com.example.demo.repository.EnemyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class FileDataService {

    @Autowired
    private EnemyRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    public void readAndSaveDataFromFile(String filePath) throws IOException {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return;
        }

        try {
            List<EnemiesModel> entities = objectMapper.readValue(
                file,
                objectMapper.getTypeFactory().constructCollectionType(List.class, EnemiesModel.class)
            );

            for (EnemiesModel enemy : entities) {
                if (!repository.existsByNick(enemy.getNick())) {
                    repository.save(enemy);
                } else {
                    System.out.println("Duplicate detected: " + enemy.getNick());
                }
            }

            String newFilePath = filePath.replace(".json", "_processed.json");
            File renamedFile = new File(newFilePath);

            if (file.renameTo(renamedFile)) {
                System.out.println("File renamed to: " + newFilePath);
            } else {
                System.out.println("Failed to rename file: " + filePath);
            }
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
            throw e; 
        }
    }
}
