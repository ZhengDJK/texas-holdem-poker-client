package com.zheng.poker.texas.client.play;

import com.zheng.poker.texas.client.controller.GameController;
import com.zheng.poker.texas.client.controller.strategy.AllIn;
import com.zheng.poker.texas.client.controller.strategy.Raise;
import com.zheng.poker.texas.client.model.Game;
import com.zheng.poker.texas.client.model.Holder;

/**
 * Created by zheng on 2017/1/4.
 */
public class RaisePlay {
    public static void main(String[] args){
        Holder holder=new Holder("Raise");
        Game game=new Game(holder);
        new Raise(game);
        GameController gameController=new GameController(game);
        gameController.play();
        game.logPlayer();
        holder.stop();
    }
}
