package com.example.cw2.service;

import com.example.cw2.model.DharshiniPlayer;
import com.example.cw2.repository.DharshiniPlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DharshiniPlayerService {

    @Autowired
    private DharshiniPlayerRepo playerRepo;

    public List<DharshiniPlayer> getAllPlayers() {
        return playerRepo.findAll();
    }

    public DharshiniPlayer getPlayerById(int id) {
        return playerRepo.findById(id).orElse(null);
    }

    public DharshiniPlayer addPlayer(DharshiniPlayer player) {
        return playerRepo.save(player);
    }
}
