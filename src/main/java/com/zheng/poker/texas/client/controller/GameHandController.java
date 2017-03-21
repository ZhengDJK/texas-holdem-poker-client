package com.zheng.poker.texas.client.controller;

import com.zheng.poker.texas.client.model.BettingRound;
import com.zheng.poker.texas.client.model.Game;
import com.zheng.poker.texas.client.model.GameHand;

/**
 * Created by zheng on 2016/12/12.
 */
public class GameHandController {

    public boolean play(Game game){
        String msg=game.getMsg();
        if(msg.equals("Game Over"))
            return true;
        GameHand gameHand=new GameHand(game);
        game.addGameHand(gameHand);
        gameHand.makePlayers(msg);
        BettingRound bettingRound=null;
        msg=game.getMsg();
        while(!msg.equals("Game hand over")){
            if(msg.substring(0,5).equals("hold/")) {
                gameHand.setHoldCards(msg);
                bettingRound=createBettingRound(gameHand);
            }
            else if(msg.substring(0,6).equals("share/")){
                gameHand.addShareCard(msg);
                bettingRound=createBettingRound(gameHand);
            }
            else if(msg.substring(0,7).equals("action/")){
                bettingRound.getAction(msg);
            }
            else if(msg.substring(0,8).equals("inquire/")){
                game.sendMsg(game.getStrategy().decision());
            }else if(msg.substring(0,7).equals("winner/")){
                gameHand.getWinner(msg);
            }

            msg=game.getMsg();
        }
        return false;
    }

    private BettingRound createBettingRound(GameHand gameHand){
        BettingRound bettingRound=new BettingRound(gameHand);
        gameHand.addBettingRound(bettingRound);
        return bettingRound;
    }
}
