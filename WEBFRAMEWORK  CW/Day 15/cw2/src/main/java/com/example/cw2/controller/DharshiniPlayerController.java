
package com.example.cw2.controller;

import com.example.cw2.model.DharshiniPlayer;
import com.example.cw2.service.DharshiniPlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/players")
public class DharshiniPlayerController {

    private static final Logger logger = LoggerFactory.getLogger(DharshiniPlayerController.class);

    @Autowired
    private DharshiniPlayerService playerService;

    @GetMapping
    public ResponseEntity<List<DharshiniPlayer>> getAllPlayers() {
        logger.info("FINISHED PROCESSING : METHOD=GET; REQUESTURI=/players; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIME TAKEN={}",
                "N/A", HttpStatus.OK.value(), "List of players", "N/A");
        List<DharshiniPlayer> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DharshiniPlayer> getPlayerById(@PathVariable("id") int id) {
        logger.info("FINISHED PROCESSING : METHOD=GET; REQUESTURI=/players/{}; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIME TAKEN={}",
                id, HttpStatus.OK.value(), "Player details", "N/A");
        DharshiniPlayer player = playerService.getPlayerById(id);
        return ResponseEntity.ok(player);
    }

    @PostMapping
    public ResponseEntity<DharshiniPlayer> addPlayer(@RequestBody DharshiniPlayer player) {
        logger.info("FINISHED PROCESSING : METHOD=POST; REQUESTURI=/players; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIME TAKEN={}",
                player, HttpStatus.CREATED.value(), "Player added successfully", "N/A");
        DharshiniPlayer savedPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }
}