package com.hobbyapp.controller;

import com.hobbyapp.model.Player;
import com.hobbyapp.service.PlayerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController extends RESTController<Player, Integer> {

    public PlayerController(PlayerService service) {
        super(service);
    }
}
