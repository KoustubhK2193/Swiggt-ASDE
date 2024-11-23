package com.arena.battlegame.Service;

import java.util.logging.Logger;

// Dice.java
// Class representing a dice used in the battle simulation
public class Dice {

    private int sides; // The number of sides on the dice
    private static final Logger logger = Logger.getLogger(Dice.class.getName());

    /**
     * Constructor to create a dice object.
     * @param sides The number of sides on the dice (default is 6 if invalid input is provided).
     */
    public Dice(int sides) {
        if (sides <= 0) {
            logger.warning("Invalid number of sides (" + sides + ") provided. Defaulting to a 6-sided dice.");
            this.sides = 6; // Default to 6-sided dice if the input is invalid
        } else {
            this.sides = sides;
            logger.info("Dice created with " + sides + " sides.");
        }
    }

    /**
     * Simulates rolling the dice, returning a random integer between 1 and the number of sides.
     * @return The result of the dice roll.
     */
    public int roll() {
        int result = (int) (Math.random() * sides) + 1;
        logger.info("Rolled the dice: " + result + " (1-" + sides + ")");
        return result;
    }

    // Main method to demonstrate the dice roll
    public static void main(String[] args) {
        try {
            Dice dice = new Dice(6); // Create a 6-sided dice
            logger.info("Rolling the dice...");
            int rollResult = dice.roll(); // Roll the dice
            logger.info("Result of the dice roll: " + rollResult);
        } catch (Exception e) {
            logger.severe("An error occurred while rolling the dice: " + e.getMessage());
        }
    }
}
