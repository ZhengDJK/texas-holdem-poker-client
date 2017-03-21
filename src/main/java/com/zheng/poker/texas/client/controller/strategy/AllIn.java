package com.zheng.poker.texas.client.controller.strategy;

import com.zheng.poker.texas.client.controller.Strategy;
import com.zheng.poker.texas.client.model.Game;

/**
 * Created by zheng on 2017/1/4.
 */
public class AllIn extends Strategy {
    public AllIn(Game game) {
        super(game);
        game.setStrategy(this);
    }

    @Override
    public String decision() {
        return "all_in";
    }
}
