package com.example.cw2.service;

import com.example.cw2.model.dayanandPlayer;
import com.example.cw2.repository.dayanandPlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private dayanandPlayerRepo playerRepo;

    public List<dayanandPlayer> getAllPlayers() {
        return playerRepo.findAll();
    }

    public dayanandPlayer getPlayerById(int id) {
        return playerRepo.findById(id).orElse(null);
    }

    public dayanandPlayer addPlayer(dayanandPlayer player) {
        return playerRepo.save(player);
    }
}
