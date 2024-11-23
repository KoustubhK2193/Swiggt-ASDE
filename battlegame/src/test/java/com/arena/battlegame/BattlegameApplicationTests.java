package com.arena.battlegame;

import com.arena.battlegame.Service.Battle;
import com.arena.battlegame.Service.Dice;
import com.arena.battlegame.Service.Player;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BattlegameApplicationTests {

	@Test
	void contextLoads() {
		// Test to ensure the application context loads successfully
		assertTrue(true);
	}

	@Test
	void testPlayerAttributesInitialization() {
		Player player = new Player(100, 50, 20);

		// Validate player attributes
		assertEquals(100, player.getHealth(), "Player health should be initialized correctly.");
		assertEquals(50, player.getStrength(), "Player strength should be initialized correctly.");
		assertEquals(20, player.getAttack(), "Player attack should be initialized correctly.");
	}

	@Test
	void testPlayerHealthReduction() {
		Player player = new Player(100, 50, 20);

		// Reduce health and validate
		player.reduceHealth(30);
		assertEquals(70, player.getHealth(), "Player health should reduce by the damage value.");

		// Test health doesn't drop below 0
		player.reduceHealth(100);
		assertEquals(0, player.getHealth(), "Player health should not drop below 0.");
	}

	@Test
	void testDiceRoll() {
		Dice dice = new Dice(6);

		// Roll the dice multiple times and validate the range
		for (int i = 0; i < 10; i++) {
			int roll = dice.roll();
			assertTrue(roll >= 1 && roll <= 6, "Dice roll should be between 1 and the number of sides.");
		}
	}

	@Test
	void testBattleSimulation() {
		Player playerA = new Player(100, 50, 20);
		Player playerB = new Player(80, 40, 25);
		Dice dice = new Dice(6);

		Battle battle = new Battle(playerA, playerB);

		// Simulate the battle
		Player winner = battle.fight(dice);

		// Verify one player wins and the other loses
		assertTrue(playerA.isAlive() || playerB.isAlive(), "One player should remain alive at the end of the battle.");
		assertFalse(playerA.isAlive() && playerB.isAlive(), "Both players cannot be alive at the end of the battle.");

		// Ensure the winner is correctly identified
		assertSame(winner, playerA.isAlive() ? playerA : playerB, "The winner should be the last player alive.");
	}

	@Test
	void testFirstAttackerSelection() {
		Player playerA = new Player(100, 50, 20);
		Player playerB = new Player(80, 40, 25);

		Battle battle = new Battle(playerA, playerB);

		// Validate first attacker selection
		Player firstAttacker = battle.selectFirstAttacker();
		assertSame(playerB, firstAttacker, "Player B should attack first as they have lower health.");
	}
}
