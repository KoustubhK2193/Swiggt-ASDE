// test/DiceTest.java

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.stream.IntStream;

public class DiceTest {

    // Test Dice Roll Range
    @Test
    public void testRollDefaultRange() {
        Dice dice = new Dice();
        int[] rolls = new int[1000];

        // Roll the dice 1000 times and store the results
        for (int i = 0; i < 1000; i++) {
            rolls[i] = dice.roll();
        }

        // Check that each roll is between 1 and 6
        for (int roll : rolls) {
            assertTrue(roll >= 1 && roll <= 6, "Roll out of range: " + roll);
        }
    }

    @Test
    public void testRollCustomRange() {
        int customSides = 10;
        Dice dice = new Dice(customSides);
        int[] rolls = new int[1000];

        // Roll the dice 1000 times and store the results
        for (int i = 0; i < 1000; i++) {
            rolls[i] = dice.roll();
        }

        // Check that each roll is between 1 and customSides
        for (int roll : rolls) {
            assertTrue(roll >= 1 && roll <= customSides, "Roll out of range: " + roll);
        }
    }

    @Test
    public void testRollDistribution() {
        Dice dice = new Dice();
        int[] rolls = new int[6000];
        int[] counts = new int[6];  // We expect 6 sides (1-6)

        // Roll the dice 6000 times and count the occurrences of each result
        for (int i = 0; i < 6000; i++) {
            rolls[i] = dice.roll();
            counts[rolls[i] - 1]++;
        }

        // Check if the distribution is roughly uniform, i.e., each side is rolled around 1000 times
        for (int count : counts) {
            assertTrue(count > 800 && count < 1200, "Distribution skewed: " + count);
        }
    }
}
