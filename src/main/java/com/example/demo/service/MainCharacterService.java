package com.example.demo.service;

import com.example.demo.models.MainCharacter;
import com.example.demo.repository.MainCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainCharacterService {
    @Autowired
    private MainCharacterRepository repository;

    public List<MainCharacter> getAllCharacters() {
        return repository.findAll();
    }

    public MainCharacter createCharacter(MainCharacter character) {
        return repository.save(character);
    }

    public MainCharacter findByNick(String nick) {
        return repository.findByNick(nick);
    }

    public void deleteCharacter(String id) {
        repository.deleteById(id);
    }
}
