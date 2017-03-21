package com.zheng.poker.texas.client.play;

import com.zheng.poker.texas.client.controller.GameController;
import com.zheng.poker.texas.client.controller.strategy.AllIn;
import com.zheng.poker.texas.client.controller.strategy.Normal;
import com.zheng.poker.texas.client.model.Game;
import com.zheng.poker.texas.client.model.Holder;

/**
 * Created by zheng on 2017/1/4.
 */
public class NormalPlay {
    public static void main(String[] args){
        Holder holder=new Holder("Normal");
        Game game=new Game(holder);
        new Normal(game);
        GameController gameController=new GameController(game);
        gameController.play();
        game.logPlayer();
        holder.stop();
    }
}
