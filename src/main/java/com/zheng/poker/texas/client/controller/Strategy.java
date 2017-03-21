package com.zheng.poker.texas.client.controller;

import com.zheng.poker.texas.client.model.Game;
import com.zheng.poker.texas.client.model.GameHand;
import com.zheng.poker.texas.client.model.Holder;
import com.zheng.poker.texas.controller.HandPowerRanker;

/**
 * Created by zheng on 2017/1/4.
 */
public abstract class Strategy {
    private final HandPowerRanker handPowerRanker=new HandPowerRanker();
    private final HandStrengthEvaluator handStrengthEvaluator=new HandStrengthEvaluator(handPowerRanker);
    private final Game game;

    public Strategy(Game game){
        this.game=game;
    }

    protected Holder getHolder(){
        return game.getHolder();
    }

    protected GameHand getGameHand(){
        return game.getCurrentGameHand();
    }

    public double getStrength(){
        return handStrengthEvaluator.evaluate(getHolder().getHoldCards(),getGameHand().getSharedCards(),getGameHand().getNumberOfPlayer());
    }

    public abstract String decision();
}
