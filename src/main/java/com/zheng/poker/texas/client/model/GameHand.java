package com.zheng.poker.texas.client.model;

import com.zheng.poker.texas.model.cards.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zheng on 2016/12/8.
 */
public class GameHand {
    private final List<Player> players=new ArrayList<Player>();
    private final List<Card> sharedCards=new ArrayList<Card>();
    private final List<BettingRound> bettingRounds=new ArrayList<BettingRound>();
    private final Game game;
    private final Map<Player,List<Card>> showCards=new HashMap<Player, List<Card>>();

    public GameHand(Game game){
        this.game=game;
    }

    public List<BettingRound> getBettingRounds() {
        return bettingRounds;
    }

    public BettingRound getCurrentBettingRound(){
        return bettingRounds.get(bettingRounds.size()-1);
    }

    public void makePlayers(String msg){
        String[] info=msg.split("\n");
        if(info[0].equalsIgnoreCase("seat/")){
            for(int i=1;i<info.length-1;i++){
                String[] playerInfo=info[i].split(" ");
                Player player=game.getPlayerByIdStr(playerInfo[0]);
                player.setJetton(Integer.parseInt(playerInfo[1]));
                player.setMoney(Integer.parseInt(playerInfo[2]));
                addPlayer(player);
            }
        }
    }

    public Holder getHolder(){
        return game.getHolder();
    }

    public void setHoldCards(String msg){
        getHolder().setHoldCards(msg);
    }

    public int getTotalPot(){
        int totalBet=0;
        for(BettingRound round:bettingRounds){
            totalBet+=round.getTotalBets();
        }
        return totalBet;
    }

    public boolean isHolder(Player player){
        return game.isHolder(player);
    }


    public void addPlayer(Player player){
        players.add(player);
    }

    public Player getPlayerByIdStr(String id){
        return game.getPlayerByIdStr(id);
    }

    public String getMsg(){
        return game.getMsg();
    }

    public void sendMsg(String msg){
        game.sendMsg(msg);
    }

    public void addShareCard(String msg){
        String cardString=msg.split("\n")[1];
        for(String s:cardString.split(" "))
            sharedCards.add(Card.fromString(s));
    }

    public List<Card> getSharedCards() {
        return sharedCards;
    }

    public void addBettingRound(BettingRound bettingRound){
        bettingRounds.add(bettingRound);
    }

    public void getWinner(String msg){
        String[] winner=msg.split("\n")[1].split(" ");
        Player player=getPlayerByIdStr(winner[0]);
        player.addJetton(Integer.parseInt(winner[1]));
    }

    public int getNumberOfPlayer(){
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
