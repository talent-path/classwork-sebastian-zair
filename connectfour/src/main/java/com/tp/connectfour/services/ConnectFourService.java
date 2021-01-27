package com.tp.connectfour.services;

import com.tp.connectfour.models.ConnectFourGame;
import com.tp.connectfour.models.ConnectFourViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConnectFourService {

    @Autowired
    ConnectFourDao dao;

    public ConnectFourViewModel startGame(){

    }

    public ConnectFourViewModel getGameById(Integer gameId) {
        ConnectFourGame game = dao.getGameById(gameId);
        return convertModel(game);
    }
}
