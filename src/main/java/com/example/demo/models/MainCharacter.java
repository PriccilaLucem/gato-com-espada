package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "main_characters")
public class MainCharacter {
    @Id
    private String nick;
    private Integer healthPoints;
    private Integer damagePoints;
    private Integer mana;
    private Integer level;

    public MainCharacter(){}

    public MainCharacter(String nick){
        this.nick = nick;
        this.healthPoints = 20;
        this.damagePoints = 6;
        this.mana = 9;
        this.level = 1;
    }

    public Integer getDamagePoints() {
        return damagePoints;
    }
    public Integer getHealthPoints() {
        return healthPoints;
    }
    public Integer getMana() {
        return mana;
    }
    public String getNick() {
        return nick;
    }
    public void setDamagePoints(Integer damagePoints) {
        this.damagePoints = damagePoints;
    }
    public void setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
    }
    public void setMana(Integer mana) {
        this.mana = mana;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
}
