package com.example.demo.repository;

import com.example.demo.models.MainCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MainCharacterRepository extends MongoRepository<MainCharacter, String> {
    MainCharacter findByNick(String nick);
}
