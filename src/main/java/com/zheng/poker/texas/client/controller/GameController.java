package com.zheng.poker.texas.client.controller;

import com.zheng.poker.texas.client.model.Game;
import com.zheng.poker.texas.client.model.Player;

/**
 * Created by zheng on 2016/12/8.
 */
public class GameController {
    private final Game game;
    private final GameHandController gameHandController=new GameHandController();

    public GameController(Game game){
        this.game=game;
    }

    public void play(){
        game.makePlayers();
        while (true){
            if(gameHandController.play(game))
                break;
        }

    }

}
