package com.example.demo.models.enemy;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "enemies")
public class EnemiesModel {
    @Id
    private String id;
    private String nick;
    private Integer healthPoints;
    private Integer damagePoints;
    private Integer mana;
    private Integer level;
    private EnemyLocationEnum location;
    

    
    public Integer getDamagePoints() {
        return damagePoints;
    }
    public Integer getHealthPoints() {
        return healthPoints;
    }

    public String getId() {
        return id;
    }
    public Integer getLevel() {
        return level;
    }
    public EnemyLocationEnum getLocation() {
        return location;
    }
    public Integer getMana() {
        return mana;
    }public String getNick() {
        return nick;
    }
    public void setDamagePoints(Integer damagePoints) {
        this.damagePoints = damagePoints;
    }
    public void setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    public void setLocation(EnemyLocationEnum location) {
        this.location = location;
    }
    public void setMana(Integer mana) {
        this.mana = mana;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
}
