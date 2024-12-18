package com.example.demo.controller;

import com.example.demo.models.MainCharacterModel;
import com.example.demo.service.MainCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class MainCharacterController {
    @Autowired
    private MainCharacterService service;

    @GetMapping
    public List<MainCharacterModel> getAllCharacters() {
        return service.getAllCharacters();
    }

    @PostMapping
    public MainCharacterModel createCharacter(@RequestBody MainCharacterModel character) {
        return service.createCharacter(character);
    }

    @GetMapping("/{nick}")
    public MainCharacterModel getCharacterByNick(@PathVariable String nick) {
        return service.findByNick(nick);
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable String id) {
        service.deleteCharacter(id);
    }
}
