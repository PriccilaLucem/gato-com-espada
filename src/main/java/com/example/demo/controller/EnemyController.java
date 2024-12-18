package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.enemy.EnemiesModel;
import com.example.demo.service.EnemyService;

@RestController
@RequestMapping("/enemy")
public class EnemyController {
    
    @Autowired
    private EnemyService enemyService;

    @GetMapping("")
    public ResponseEntity<List<EnemiesModel>> getEnemies(){
        return ResponseEntity.ok().body(enemyService.listAllEnemies());
    }
}
