
package com.example.cw2.controller;

import com.example.cw2.model.dayanandPlayer;
import com.example.cw2.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/players")
public class dayanandPlayerController {

    private static final Logger logger = LoggerFactory.getLogger(dayanandPlayerController.class);

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<dayanandPlayer>> getAllPlayers() {
        logger.info("FINISHED PROCESSING : METHOD=GET; REQUESTURI=/players; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIME TAKEN={}",
                "N/A", HttpStatus.OK.value(), "List of players", "N/A");
        List<dayanandPlayer> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/{id}")
    public ResponseEntity<dayanandPlayer> getPlayerById(@PathVariable("id") int id) {
        logger.info("FINISHED PROCESSING : METHOD=GET; REQUESTURI=/players/{}; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIME TAKEN={}",
                id, HttpStatus.OK.value(), "Player details", "N/A");
        dayanandPlayer player = playerService.getPlayerById(id);
        return ResponseEntity.ok(player);
    }

    @PostMapping
    public ResponseEntity<dayanandPlayer> addPlayer(@RequestBody dayanandPlayer player) {
        logger.info("FINISHED PROCESSING : METHOD=POST; REQUESTURI=/players; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIME TAKEN={}",
                player, HttpStatus.CREATED.value(), "Player added successfully", "N/A");
        dayanandPlayer savedPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }
}