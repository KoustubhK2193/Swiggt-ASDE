package com.example.BattleInMagicalArena;

import org.springframework.boot.SpringApplication;

public class TestBattleInMagicalArenaApplication {

	public static void main(String[] args) {
		SpringApplication.from(BattleInMagicalArenaApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
