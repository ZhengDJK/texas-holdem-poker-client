package com.zheng.poker.texas.client.model;

import com.zheng.poker.texas.model.BettingDecision;
import com.zheng.poker.texas.model.BettingMoney;
import com.zheng.poker.texas.model.cards.Card;
import javafx.util.Pair;

import java.util.*;

/**
 * Created by zheng on 2016/12/9.
 */
public class BettingRound {
    private final List<Pair<Player,BettingMoney>> playerBettingMoneys=new ArrayList<Pair<Player, BettingMoney>>();
    private final Map<Player,Integer> playerBets =new HashMap<Player, Integer>();
    private final Map<Player,List<Card>> playerHoldCards=new HashMap<Player, List<Card>>();
    private int highestBet=0;
    private final GameHand gameHand;

    public BettingRound(GameHand gameHand){
        this.gameHand=gameHand;
    }

    public Map<Player, Integer> getPlayerBets() {
        return playerBets;
    }

    public void getAction(String msg){
        String[] info=msg.split("\n");
        if(info[0].equalsIgnoreCase("action/")){
            String[] action=info[1].split(" ");
            Player player=gameHand.getPlayerByIdStr(action[0]);
            player.setJetton(Integer.parseInt(action[1]));
            player.setMoney(Integer.parseInt(action[2]));
            int bet=Integer.parseInt(action[3]);
            BettingDecision bettingDecision=BettingDecision.getDecision(action[4]);
            int highestBet=Integer.parseInt(action[5]);
            if(bettingDecision.equals(BettingDecision.RAISE)){
                playerBettingMoneys.add(new Pair<Player, BettingMoney>(player,new BettingMoney(bettingDecision,bet-this.highestBet)));
            }else {
                playerBettingMoneys.add(new Pair<Player, BettingMoney>(player,new BettingMoney(bettingDecision,0)));
            }
            if(highestBet>this.highestBet){
                this.highestBet=highestBet;
            }
            playerBets.put(player,bet);
        }
    }

    public int getNeed(){
        return highestBet-getBetForPlayer(gameHand.getHolder().getPlayer());
    }

    public int getNeedForPlayer(Player player){
        return highestBet-getBetForPlayer(player);
    }

    public int getBetForPlayer(Player player) {
        Integer bet = playerBets.get(player);
        if (bet == null) {
            return 0;
        }
        return bet;
    }

    public void getShow(String msg){
        String[] show=msg.split("\n");
        if(show[0].equalsIgnoreCase("show/")){
            for(int i=1;i<show.length-1;i++){
                String[] playerMsg=show[i].split(" ");
                Player player=gameHand.getPlayerByIdStr(playerMsg[0]);
                Card holdCard1=Card.fromString(playerMsg[1]);
                Card holdCard2=Card.fromString(playerMsg[2]);
                playerHoldCards.put(player,new ArrayList<Card>(Arrays.asList(holdCard1, holdCard2)));
            }
        }
    }

    public boolean isShow(){
        return !playerHoldCards.isEmpty();
    }

    public Map<Player, List<Card>> getPlayerHoldCards() {
        return playerHoldCards;
    }

    public int getTotalBets() {
        int totalBets = 0;
        for (Integer bet : playerBets.values()) {
            totalBets += bet;
        }
        return totalBets;
    }
}
