package com.tp.connectfour.persistence;

import com.tp.connectfour.models.ConnectFourGame;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConnectFourInMemDao implements ConnectFourDao{

    private List<ConnectFourGame> allGames = new ArrayList<>();
    public ConnectFourInMemDao(){
        ConnectFourGame game = new ConnectFourGame(100);
        allGames.add(game);
    }
    @Override
    public Integer startGame() {

        int id = 0;
        ConnectFourGame toReturn = null;
        for(ConnectFourGame toCheck: allGames){
            if(toCheck.getGameId() > id){
                id = toCheck.getGameId();
            }
        }
        id++;
        ConnectFourGame toAdd = new ConnectFourGame(id);
        allGames.add(toAdd);
       // return null;

        return id;
    }
}
