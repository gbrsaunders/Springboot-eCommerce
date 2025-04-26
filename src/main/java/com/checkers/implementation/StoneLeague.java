package com.checkers.implementation;

import com.checkers.interfaces.League;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class StoneLeague implements League {
    @Override
    public String showLeagueIcon() {
        return "";
    }

    @Override
    public String toString() {
        return "Stone League";
    }

    @Override
    public String showLeaguePosition() {
        Random rand = new Random();
        int position = rand.nextInt(1,5);

        return "You are in position:" + position;
    }

    @Override
    public void adjustLeaguePosition() {

    }
}