package com.checkers.beans;

import com.checkers.services.GameStatsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("gameStatsBean")
public class GameStats {
    private final GameStatsServices gameStatsServices;

    @Autowired
    public GameStats(GameStatsServices gameStatsServices) {
        this.gameStatsServices = gameStatsServices;
    }

    public GameStatsServices getGameStatsServices() {
        return gameStatsServices;
    }
}
