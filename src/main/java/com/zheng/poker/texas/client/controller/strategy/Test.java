package com.zheng.poker.texas.client.controller.strategy;

import com.zheng.poker.texas.client.controller.Strategy;
import com.zheng.poker.texas.client.model.Game;
import com.zheng.poker.texas.client.model.Player;

/**
 * Created by zheng on 2017/1/4.
 */
public class Test extends Strategy {
    public Test(Game game) {
        super(game);
        game.setStrategy(this);
    }

    @Override
    public String decision() {
        double strength=getStrength();
        int pot=getGameHand().getTotalPot();
        int need=getGameHand().getCurrentBettingRound().getNeed();
        int callPot=pot;
        for(Player player:getGameHand().getPlayers()){
            callPot+=getGameHand().getCurrentBettingRound().getNeedForPlayer(player);
        }
        callPot=pot+need;
        int win=(int)(callPot*strength);
        if(win<need)
            return "fold";
        if(strength<0.6)
            return "call";
        if(strength<0.7)
            return "raise 200";
        if(strength<0.8)
            return "raise 500";
        return "all_in";
    }
}
