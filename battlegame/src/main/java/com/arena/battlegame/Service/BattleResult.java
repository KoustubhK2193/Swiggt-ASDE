package com.arena.battlegame.Service;


public class BattleResult {
    private String winner;
    private int playerAHealth;
    private int playerBHealth;

    public BattleResult(String winner, int playerAHealth, int playerBHealth) {
        this.winner = winner;
        this.playerAHealth = playerAHealth;
        this.playerBHealth = playerBHealth;
    }

    // Getters
    public String getWinner() {
        return winner;
    }

    public int getPlayerAHealth() {
        return playerAHealth;
    }

    public int getPlayerBHealth() {
        return playerBHealth;
    }
}
