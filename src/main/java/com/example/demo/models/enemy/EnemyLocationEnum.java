package com.example.demo.models.enemy;

public enum EnemyLocationEnum {
    AREA1("area1");

    private final String location;

    EnemyLocationEnum(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
