package com.checkers.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    private final GameStats gameStats;
    @Autowired
    public Person(GameStats gameStats) {
        this.gameStats = gameStats;

    }

    public GameStats getGameStats() {
        return gameStats;
    }
}
