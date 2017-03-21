package com.zheng.poker.texas.client.play;

import com.zheng.poker.texas.client.controller.GameController;
import com.zheng.poker.texas.client.controller.strategy.Raise;
import com.zheng.poker.texas.client.controller.strategy.Test;
import com.zheng.poker.texas.client.model.Game;
import com.zheng.poker.texas.client.model.Holder;

/**
 * Created by zheng on 2017/1/4.
 */
public class TestPlay {
    public static void main(String[] args){
        Holder holder=new Holder("Test");
        Game game=new Game(holder);
        new Test(game);
        GameController gameController=new GameController(game);
        gameController.play();
        game.logPlayer();
        holder.stop();
    }
}
