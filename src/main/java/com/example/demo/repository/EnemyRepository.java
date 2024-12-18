package com.example.demo.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.models.enemy.EnemiesModel;

public interface EnemyRepository extends MongoRepository<EnemiesModel, String>{
    boolean existsByNick(String nick);

}
