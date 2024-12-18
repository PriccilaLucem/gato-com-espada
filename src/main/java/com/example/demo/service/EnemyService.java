package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.enemy.EnemiesModel;
import com.example.demo.repository.EnemyRepository;

@Service
public class EnemyService {
    
    @Autowired
    private EnemyRepository enemyRepository;

    public List<EnemiesModel> listAllEnemies(){
        return  enemyRepository.findAll();
    }
}
