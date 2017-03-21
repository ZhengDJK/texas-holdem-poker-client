package com.zheng.poker.texas.client.controller;

import com.zheng.poker.texas.controller.HandPowerRanker;
import com.zheng.poker.texas.model.HandPower;
import com.zheng.poker.texas.model.cards.Card;
import com.zheng.poker.texas.model.cards.Deck;
import com.zheng.poker.texas.simulate.GetHoldCardStrength;
import com.zheng.poker.texas.simulate.GetHoldCardsStrength;
import com.zheng.poker.texas.simulate.HoldCard;
import com.zheng.poker.texas.simulate.HoldCards;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zheng on 2016/12/14.
 */
public class HandStrengthEvaluator {

    private List<Map<HoldCard,Double>> holdCardStrength= GetHoldCardsStrength.getHoldCardStrength();

    private final HandPowerRanker handPowerRanker;

    public HandStrengthEvaluator(final HandPowerRanker handPowerRanker) {
        this.handPowerRanker = handPowerRanker;
    }

    public double evaluate(List<Card> playerHoleCards, List<Card> sharedCards, Integer numberOfPlayers) {
        if(sharedCards == null || sharedCards.isEmpty()){
            return holdCardStrength.get(numberOfPlayers-2).get(new HoldCard(playerHoleCards.get(0),playerHoleCards.get(1)));
        }

        int wins = 0;
        int losses = 0;
        int ties = 0;

        Deck deck = new Deck();
        Card hole1 = playerHoleCards.get(0);
        Card hole2 = playerHoleCards.get(1);
        deck.removeCard(hole1);
        deck.removeCard(hole2);
        for (Card card : sharedCards) {
            deck.removeCard(card);
        }

        List<List<Card>> couplesOfCards = deck.fromDeckToCouplesOfCard();

        List<Card> playerCards = new ArrayList<Card>();
        playerCards.addAll(playerHoleCards);
        playerCards.addAll(sharedCards);
        HandPower playerRank = handPowerRanker.rank(playerCards);

        for (List<Card> couple : couplesOfCards) {
            List<Card> opponentCards = new ArrayList<Card>();
            opponentCards.addAll(couple);
            opponentCards.addAll(sharedCards);
            HandPower opponentRank = handPowerRanker.rank(opponentCards);

            int result = playerRank.compareTo(opponentRank);
            if (result > 0) {
                wins++;
            } else if (result < 0) {
                losses++;
            } else {
                ties++;
            }
        }
        return calculateHandStrength(wins, ties, losses, numberOfPlayers);
    }

    private double calculateHandStrength(int wins, int ties, int losses, int numberOfPlayers) {
        double num = (wins + 0.5 * ties);
        double den = (wins + losses + ties);
        return Math.pow(num / den, numberOfPlayers);
    }



}