package com.arena.battlegame.Service;


public class BattleRequest {

    private int playerA_health;
    private int playerA_attack;
    private int playerA_strength;

    private int playerB_health;
    private int playerB_attack;
    private int playerB_strength;

    public int getPlayerA_health() {
        return playerA_health;
    }

    public int getPlayerA_attack() {
        return playerA_attack;
    }

    public int getPlayerA_strength() {
        return playerA_strength;
    }

    public int getPlayerB_attack() {
        return playerB_attack;
    }

    public int getPlayerB_health() {
        return playerB_health;
    }

    public int getPlayerB_strength() {
        return playerB_strength;
    }
}
