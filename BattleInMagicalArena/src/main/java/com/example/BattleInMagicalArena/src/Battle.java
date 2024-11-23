package com.example.BattleInMagicalArena.src;// com.example.BattleInMagicalArena.src.Battle.java

// Class representing a battle between two players
public class Battle {

    private Player playerA;  // The first player in the battle
    private Player playerB;  // The second player in the battle

    /**
     * Constructor to initialize the two players for the battle.
     * @param playerA The first player in the battle.
     * @param playerB The second player in the battle.
     */
    public Battle(Player playerA, Player playerB) {
        // Initialize the two players for the battle
        this.playerA = playerA;
        this.playerB = playerB;
    }

    /**
     * Decides which player attacks first based on health.
     * @return The player who will attack first.
     */
    public Player selectFirstAttacker() {
        // If playerA has less or equal health, they attack first; otherwise, playerB attacks
        return this.playerA.getHealth() <= this.playerB.getHealth() ? this.playerA : this.playerB;
    }

    /**
     * Main fight method, simulating the battle until one player is defeated.
     * @param dice The dice object used to determine attack and defense rolls.
     * @return The winner of the battle, the player who survives.
     */
    public Player fight(Dice dice) {
        // Determine the first attacker based on health
        Player attacker = selectFirstAttacker();
        Player defender = (attacker == this.playerA) ? this.playerB : this.playerA;

        // Safety limit to prevent infinite loops in case of unexpected behavior
        int limitToRunLoop = 1000;
        int currentLoopNumber = 1;

        // Continue the battle until one player is no longer alive or the loop limit is reached
        while (this.playerA.isAlive() && this.playerB.isAlive() && currentLoopNumber < limitToRunLoop) {
            // Each player rolls the dice for their attack and defense
            int attackRoll = dice.roll();
            int defendRoll = dice.roll();

            System.out.println("Iteration number: " + currentLoopNumber + "\n");

            // Debugging information: log the current attacker, defender, and their health
            if (attacker == this.playerA) {
                System.out.println("Player A is the attacker and Player B is the defender\n");
            } else {
                System.out.println("Player B is the attacker and Player A is the defender\n");
            }

            System.out.println("Player A health: " + this.playerA.getHealth() + "\n" + "Player B health: " + this.playerB.getHealth() + "\n");

            // Calculate attack damage and defense strength based on dice rolls
            int attackDamage = attacker.getAttack() * attackRoll;
            int defendStrength = defender.getStrength() * defendRoll;

            // Debugging information: log the attack and defense values
            if (attacker == this.playerA) {
                System.out.println("Player A attacked with: " + attackDamage + "\n" + "Player B defended with: " + defendStrength + "\n");
            } else {
                System.out.println("Player B attacked with: " + attackDamage + "\n" + "Player A defended with: " + defendStrength + "\n");
            }

            // Calculate net damage to the defender (minimum of 0 to prevent healing)
            int netDamage = Math.max(0, attackDamage - defendStrength);

            // Reduce the defender's health based on the net damage
            defender.reduceHealth(netDamage);

            // Debugging information: log the updated health of both players
            System.out.println("Player A health: " + this.playerA.getHealth() + "\n" + "Player B health: " + this.playerB.getHealth() + "\n\n\n");

            // Swap the roles of attacker and defender for the next round
            Player temp = attacker;
            attacker = defender;
            defender = temp;

            // Increment the loop counter to track the number of rounds
            currentLoopNumber++;
        }

        // Determine the winner: the player who is still alive
        return this.playerA.isAlive() ? this.playerA : this.playerB;
    }

    // Main method to simulate a battle (example usage)
    public static void main(String[] args) {
        try {
            // Create two players
            Player playerA = new Player(100, 50, 20);
            Player playerB = new Player(100, 40, 25);

            // Create a dice object
            Dice dice = new Dice(6);

            // Create a battle between playerA and playerB
            Battle battle = new Battle(playerA, playerB);

            // Simulate the battle and determine the winner
            Player winner = battle.fight(dice);
            System.out.println("The winner is: " + (winner == playerA ? "Player A" : "Player B"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
