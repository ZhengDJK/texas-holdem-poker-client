package com.zheng.poker.texas.client;

import com.zheng.poker.texas.client.controller.HandStrengthEvaluator;
import com.zheng.poker.texas.controller.HandPowerRanker;
import com.zheng.poker.texas.model.HandPower;
import com.zheng.poker.texas.model.cards.Card;
import com.zheng.poker.texas.model.cards.Deck;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zheng on 2017/1/4.
 */
public class StrengthTest {

    public static void main(String[] args){
        HandPowerRanker handPowerRanker=new HandPowerRanker();
        HandStrengthEvaluator strengthEvaluator=new HandStrengthEvaluator(handPowerRanker);
        Deck deck;
        List<Card> holdCard=new ArrayList<Card>();
        List<Card> hold2=new ArrayList<Card>();
        List<Card> shareCard=new ArrayList<Card>();
        holdCard.add(Card.fromString("♥A"));
        holdCard.add(Card.fromString("♥8"));
        hold2.add(Card.fromString("♠8"));
        hold2.add(Card.fromString("♣A"));
        shareCard.add(Card.fromString("♦3"));
        shareCard.add(Card.fromString("♥2"));
        shareCard.add(Card.fromString("♦6"));
        shareCard.add(Card.fromString("♠3"));
        shareCard.add(Card.fromString("♥Q"));

        holdCard.addAll(shareCard);
        hold2.addAll(shareCard);

        HandPower power1=handPowerRanker.rank(holdCard);
        HandPower power2=handPowerRanker.rank(hold2);
        System.out.println(power1.equals(power2));
        System.out.println(power1.getTieBreakingInformation().hashCode());
        System.out.println(power2.getTieBreakingInformation().hashCode());
        System.out.println(power1.hashCode());
        System.out.println(power2.hashCode());


        /*for(int i=0;i<600;i++){
            deck=new Deck();
            holdCard.clear();
            shareCard.clear();
            holdCard.add(deck.removeTopCard());
            holdCard.add(deck.removeTopCard());
            System.out.println(holdCard + " " + shareCard + " " + strengthEvaluator.evaluate(holdCard, shareCard, 2));
            shareCard.add(deck.removeTopCard());
            shareCard.add(deck.removeTopCard());
            shareCard.add(deck.removeTopCard());
            System.out.println(holdCard+" "+shareCard+" "+strengthEvaluator.evaluate(holdCard,shareCard,2));
            shareCard.add(deck.removeTopCard());
            System.out.println(holdCard+" "+shareCard+" "+strengthEvaluator.evaluate(holdCard,shareCard,2));
            shareCard.add(deck.removeTopCard());
            System.out.println(holdCard+" "+shareCard+" "+strengthEvaluator.evaluate(holdCard,shareCard,2));
        }*/
    }
}
