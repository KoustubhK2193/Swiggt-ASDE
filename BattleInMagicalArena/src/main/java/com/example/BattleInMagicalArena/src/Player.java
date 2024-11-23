package com.example.BattleInMagicalArena.src;

// Player.java

// Class representing a player in the battle
public class Player {

    private int health;  // The player's health points
    private int strength; // The player's defensive strength
    private int attack;  // The player's attack power

    /**
     * Constructor to initialize a player's attributes.
     *
     * @param health   The player's initial health points.
     * @param strength The player's defensive strength.
     * @param attack   The player's attack power.
     * @throws IllegalArgumentException Throws an exception if any attribute is invalid (non-positive).
     */
    public Player(int health, int strength, int attack) {
        // Validate that all attributes are positive values
        if (health <= 0 || strength <= 0 || attack <= 0) {
            throw new IllegalArgumentException("Invalid player attributes"); // Prevents creating players with invalid stats
        }
        // Initialize player's attributes
        this.health = health; // Health points determine the player's life
        this.strength = strength; // Strength determines defense capability
        this.attack = attack; // Attack determines offensive capability
    }

    /**
     * Reduces the player's health by a given damage value.
     * If the damage exceeds current health, the health is set to 0 (player dies).
     *
     * @param damage The amount of damage taken by the player.
     */
    public void reduceHealth(int damage) {
        // Subtract damage from health, ensuring health doesn't drop below 0
        this.health = Math.max(0, this.health - damage);
    }

    /**
     * Checks if the player is still alive.
     * A player is alive if their health is greater than 0.
     *
     * @return True if the player is alive, false otherwise.
     */
    public boolean isAlive() {
        return this.health > 0;
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
            Player player = new Player(100, 50, 20); // Create a player with 100 health, 50 strength, 20 attack
            System.out.println("Player created with Health: " + player.getHealth());

            player.reduceHealth(30);  // Reduce health by 30
            System.out.println("After taking damage, Health: " + player.getHealth());

            if (player.isAlive()) {
                System.out.println("The player is alive.");
            } else {
                System.out.println("The player is dead.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
