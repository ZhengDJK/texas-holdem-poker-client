package com.zheng.poker.texas.client.controller;

import com.zheng.poker.texas.client.model.Game;
import com.zheng.poker.texas.client.model.GameHand;
import com.zheng.poker.texas.client.model.Holder;
import com.zheng.poker.texas.controller.HandPowerRanker;

/**
 * Created by zheng on 2016/12/14.
 */
public class Decision {
    //private final Holder holder;
    private final HandPowerRanker handPowerRanker=new HandPowerRanker();
    private final HandStrengthEvaluator handStrengthEvaluator=new HandStrengthEvaluator(handPowerRanker);
    private final Game game;

    public Decision(Game game){
        this.game=game;
    }

    private Holder getHolder(){
        return game.getHolder();
    }

    private GameHand getGameHand(){
        return game.getCurrentGameHand();
    }

    public double getStrength(){
        return handStrengthEvaluator.evaluate(getHolder().getHoldCards(),getGameHand().getSharedCards(),getGameHand().getNumberOfPlayer());
    }
    public String getDecision(){
        double strength=getStrength();
        if(strength<0.5 && getGameHand().getCurrentBettingRound().getNeed()>0 && getGameHand().getBettingRounds().size()>1)
            return "fold";
        else if(strength<0.3 && getGameHand().getBettingRounds().size()==1)
            return "fold";
        else if(strength>0.3 && strength<0.5 && getGameHand().getBettingRounds().size()==1)
            return "call";
        else if(strength<0.6 || getGameHand().getCurrentBettingRound().getNeed()==0)
            return "call";
        else if(strength<0.7)
            return "raise 200";
        else if(strength<0.8)
            return "raise 500";
        else
            return "all_in";

    }
}
