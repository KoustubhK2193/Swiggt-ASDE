package com.arena.battlegame.Service;

import java.util.logging.Logger;

public class Player {

    private int health;  // The player's health points
    private int strength; // The player's defensive strength
    private int attack;  // The player's attack power

    private static final Logger logger = Logger.getLogger(Player.class.getName());

    /**
     * Constructor to initialize a player's attributes.
     *
     * @param health   The player's initial health points.
     * @param strength The player's defensive strength.
     * @param attack   The player's attack power.
     * @throws IllegalArgumentException Throws an exception if any attribute is invalid (non-positive).
     */
    public Player(int health, int strength, int attack) {
        if (health <= 0 || strength <= 0 || attack <= 0) {
            logger.severe("Invalid player attributes: health=" + health + ", strength=" + strength + ", attack=" + attack);
            throw new IllegalArgumentException("Invalid player attributes");
        }
        this.health = health;
        this.strength = strength;
        this.attack = attack;
        logger.info("Player created with Health: " + this.health + ", Strength: " + this.strength + ", Attack: " + this.attack);
    }

    /**
     * Reduces the player's health by a given damage value.
     * If the damage exceeds current health, the health is set to 0 (player dies).
     *
     * @param damage The amount of damage taken by the player.
     */
    public void reduceHealth(int damage) {
        int oldHealth = this.health;
        this.health = Math.max(0, this.health - damage);
        logger.info("Player's health reduced by " + damage + ". Health changed from " + oldHealth + " to " + this.health);
    }

    /**
     * Checks if the player is still alive.
     * A player is alive if their health is greater than 0.
     *
     * @return True if the player is alive, false otherwise.
     */
    public boolean isAlive() {
        boolean alive = this.health > 0;
        logger.info("Checking if player is alive: " + alive);
        return alive;
    }

    // Getter methods to retrieve the player's attributes
    public int getHealth() {
        return this.health;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getAttack() {
        return this.attack;
    }

    // Main method to demonstrate the player functionality
    public static void main(String[] args) {
        try {
            Player player = new Player(100, 50, 20);
            logger.info("Player created with Health: " + player.getHealth());

            player.reduceHealth(30);
            logger.info("After taking damage, Health: " + player.getHealth());

            if (player.isAlive()) {
                logger.info("The player is alive.");
            } else {
                logger.warning("The player is dead.");
            }
        } catch (IllegalArgumentException e) {
            logger.severe("Error creating player: " + e.getMessage());
        }
    }
}
