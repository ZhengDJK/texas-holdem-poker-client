package com.zheng.poker.texas.client;

import com.zheng.poker.texas.client.controller.GameController;
import com.zheng.poker.texas.client.controller.Strategy;
import com.zheng.poker.texas.client.controller.strategy.Normal;
import com.zheng.poker.texas.client.model.Game;
import com.zheng.poker.texas.client.model.Holder;

/**
 * Created by zheng on 2016/12/12.
 */
public class Play {
    public static void main(String[] args){
        Holder holder=new Holder("Normal");
        Game game=new Game(holder);
        new Normal(game);
        GameController gameController=new GameController(game);
        gameController.play();
        //game.makePlayers();
        /*game.logPlayer();
        String msg=holder.getMsg();
        while (!msg.equalsIgnoreCase("Game Over")){
            if(msg.substring(0,7).equalsIgnoreCase("inquire"))
                holder.sendMsg("call");
            msg=holder.getMsg();
        }*/
        game.logPlayer();
        holder.stop();
    }
}
