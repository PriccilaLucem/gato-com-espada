package com.example.demo.service;

import com.example.demo.models.MainCharacterModel;
import com.example.demo.repository.MainCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainCharacterService {
    @Autowired
    private MainCharacterRepository repository;

    public List<MainCharacterModel> getAllCharacters() {
        return repository.findAll();
    }

    public MainCharacterModel createCharacter(MainCharacterModel character) {
        return repository.save(character);
    }

    public MainCharacterModel findByNick(String nick) {
        return repository.findByNick(nick);
    }

    public void deleteCharacter(String id) {
        repository.deleteById(id);
    }
}
