package com.zheng.poker.texas.client.controller.strategy;

import com.zheng.poker.texas.client.controller.Strategy;
import com.zheng.poker.texas.client.model.Game;

/**
 * Created by zheng on 2017/1/4.
 */
public class Normal extends Strategy {
    public Normal(Game game) {
        super(game);
        game.setStrategy(this);
    }

    @Override
    public String decision() {
        double strength=getStrength();
        int pot=getGameHand().getTotalPot();
        int need=getGameHand().getCurrentBettingRound().getNeed();
        String decision="";
        if(need>0&&strength<0.3)
            decision="fold";
        else if(need>=500&& strength<0.5)
            decision="fold";
        else if(strength<0.5)
            decision="call";
        else if(need<200 && strength<0.7)
            decision="raise 200";
        else if(strength<0.7)
            decision="call";
        else if(strength<0.8)
            decision="raise 200";
        else
            decision="all_in";
        return decision;
    }
}
