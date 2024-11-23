package com.arena.battlegame.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

// Class representing a battle between two players
public class Battle {

    private static final Logger logger = Logger.getLogger(Battle.class.getName()); // Logger instance

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
        return this.playerA.getHealth() <= this.playerB.getHealth() ? this.playerA : this.playerB;
    }

    /**
     * Main fight method, simulating the battle until one player is defeated.
     * @param dice The dice object used to determine attack and defense rolls.
     * @return The winner of the battle, the player who survives.
     */
    public Player fight(Dice dice) {
        Player attacker = selectFirstAttacker();
        Player defender = (attacker == this.playerA) ? this.playerB : this.playerA;

        int limitToRunLoop = 1000;
        int currentLoopNumber = 1;

        while (this.playerA.isAlive() && this.playerB.isAlive() && currentLoopNumber < limitToRunLoop) {
            int attackRoll = dice.roll();
            int defendRoll = dice.roll();

            logger.log(Level.INFO, "Iteration number: {0}", currentLoopNumber);

            if (attacker == this.playerA) {
                logger.log(Level.INFO, "Player A is the attacker and Player B is the defender");
            } else {
                logger.log(Level.INFO, "Player B is the attacker and Player A is the defender");
            }

            logger.log(Level.INFO, "Player A health: {0}, Player B health: {1}",
                    new Object[]{this.playerA.getHealth(), this.playerB.getHealth()});

            int attackDamage = attacker.getAttack() * attackRoll;
            int defendStrength = defender.getStrength() * defendRoll;

            if (attacker == this.playerA) {
                logger.log(Level.INFO, "Player A attacked with: {0}, Player B defended with: {1}",
                        new Object[]{attackDamage, defendStrength});
            } else {
                logger.log(Level.INFO, "Player B attacked with: {0}, Player A defended with: {1}",
                        new Object[]{attackDamage, defendStrength});
            }

            int netDamage = Math.max(0, attackDamage - defendStrength);
            defender.reduceHealth(netDamage);

            logger.log(Level.INFO, "After attack: Player A health: {0}, Player B health: {1}",
                    new Object[]{this.playerA.getHealth(), this.playerB.getHealth()});

            Player temp = attacker;
            attacker = defender;
            defender = temp;

            currentLoopNumber++;
        }

        return this.playerA.isAlive() ? this.playerA : this.playerB;
    }

}
