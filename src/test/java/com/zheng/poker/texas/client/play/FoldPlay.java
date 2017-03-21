package com.zheng.poker.texas.client.play;

import com.zheng.poker.texas.client.controller.GameController;
import com.zheng.poker.texas.client.controller.strategy.AllIn;
import com.zheng.poker.texas.client.controller.strategy.Fold;
import com.zheng.poker.texas.client.model.Game;
import com.zheng.poker.texas.client.model.Holder;

/**
 * Created by zheng on 2017/1/4.
 */
public class FoldPlay {
    public static void main(String[] args){
        Holder holder=new Holder("Fold");
        Game game=new Game(holder);
        new Fold(game);
        GameController gameController=new GameController(game);
        gameController.play();
        game.logPlayer();
        holder.stop();
    }
}
