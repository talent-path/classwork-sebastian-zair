package com.tp.connectfour.controller;

import com.tp.connectfour.models.ConnectFourViewModel;
import com.tp.connectfour.services.ConnectFourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectFourController {

    @Autowired
    ConnectFourService service;

    public ConnectFourViewModel getGameById(@PathVariable Integer gameId){
        return service.getGameById(gameId);
    }
}
