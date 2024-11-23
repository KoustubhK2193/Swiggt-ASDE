// test/BattleTest.java

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BattleTest {

    // Test First Attacker Selection
    @Test
    public void testSelectFirstAttacker() {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);
        Battle battle = new Battle(playerA, playerB);

        // The player with lower health should attack first
        Player firstAttacker = battle.selectFirstAttacker();
        assertEquals(playerA, firstAttacker);
    }

    // Test Battle Mechanics
    @Test
    public void testBattleEndsWithOnePlayerAlive() {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);
        Dice testDice = new Dice();

        Battle battle = new Battle(playerA, playerB);
        Player winner = battle.fight(testDice);

        // Ensure that the winner is still alive
        assertTrue(winner.isAlive());
        assertTrue(winner == playerA || winner == playerB);
    }

    @Test
    public void testBattleReducesPlayerHealth() {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);
        Dice testDice = new Dice();

        Battle battle = new Battle(playerA, playerB);
        battle.fight(testDice);

        // Ensure health values have changed from initial values
        assertNotEquals(50, playerA.getHealth());
        assertNotEquals(100, playerB.getHealth());
    }
}
