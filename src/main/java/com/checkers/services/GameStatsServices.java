package com.checkers.services;

import com.checkers.interfaces.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class GameStatsServices {
        private int points;
        @Autowired
        private League league;

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}
