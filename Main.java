// src/Main.java

import java.util.Scanner;

public class Main {

    // Utility function to get a positive numeric input from the user
    public static int getPositiveNumber(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value > 0) {
                    return value;  // Return the valid positive number
                } else {
                    System.out.println("Invalid input. Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    // Main function to set up and execute the battle simulation
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Get Player A's attributes
            System.out.println("Enter attributes for Player A:");
            int healthA = getPositiveNumber("Health: ");
            int strengthA = getPositiveNumber("Strength: ");
            int attackA = getPositiveNumber("Attack: ");

            // Get Player B's attributes
            System.out.println("\nEnter attributes for Player B:");
            int healthB = getPositiveNumber("Health: ");
            int strengthB = getPositiveNumber("Strength: ");
            int attackB = getPositiveNumber("Attack: ");

            // Create two players with the provided attributes
            Player playerA = new Player(healthA, strengthA, attackA);
            Player playerB = new Player(healthB, strengthB, attackB);

            // Create a 6-sided dice instance (default)
            Dice dice = new Dice();

            // Set up the battle between Player A and Player B
            Battle battle = new Battle(playerA, playerB);

            // Execute the fight and determine the winner
            Player winner = battle.fight(dice);

            // Output the winner's remaining health
            System.out.println("\nWinner: Player with remaining health " + winner.getHealth());
        } catch (Exception e) {
            // Handle any errors (e.g., invalid attributes or unexpected issues)
            System.out.println("Error: " + e.getMessage());
        }
    }
}
