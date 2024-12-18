package com.example.demo.repository;

import com.example.demo.models.MainCharacterModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MainCharacterRepository extends MongoRepository<MainCharacterModel, String> {
    MainCharacterModel findByNick(String nick);
}
