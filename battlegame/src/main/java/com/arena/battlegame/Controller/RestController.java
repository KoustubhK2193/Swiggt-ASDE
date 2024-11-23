package com.arena.battlegame.Controller;

import com.arena.battlegame.Service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    @GetMapping("playGame")
    public ResponseEntity<BattleResult> startGame(@RequestBody BattleRequest req){
        Player playerA = new Player(req.getPlayerA_health(), req.getPlayerA_strength(), req.getPlayerA_attack());
        Player playerB = new Player(req.getPlayerB_health(), req.getPlayerB_strength(), req.getPlayerB_attack());

        // Create a dice object
        Dice dice = new Dice(6);

        // Create a battle between playerA and playerB
        Battle battle = new Battle(playerA, playerB);

        // Simulate the battle and determine the winner
        Player winner = battle.fight(dice);

        return new ResponseEntity<>(new BattleResult(winner == playerA ? "Player A" : "Player B",
                playerA.getHealth(), playerB.getHealth()), HttpStatus.OK);
    }
}
