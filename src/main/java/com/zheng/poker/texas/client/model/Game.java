package com.zheng.poker.texas.client.model;

import com.zheng.poker.texas.client.controller.Decision;
import com.zheng.poker.texas.client.controller.Strategy;
import com.zheng.poker.texas.utils.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zheng on 2016/12/8.
 */
public class Game {
    private final List<Player> players=new ArrayList<Player>();
    private final List<GameHand> gameHands=new ArrayList<GameHand>();
    private final Holder holder;
    private final Decision decision;
    private Strategy strategy;

    public Game(Holder holder){
        this.holder=holder;
        this.decision=new Decision(this);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public Decision getDecision() {
        return decision;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Holder getHolder() {
        return holder;
    }

    public List<GameHand> getGameHands() {
        return gameHands;
    }

    public GameHand getCurrentGameHand(){
        return gameHands.get(gameHandCount()-1);
    }

    public void addGameHand(GameHand gameHand){
        gameHands.add(gameHand);
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public String getMsg(){
        return holder.getMsg();
    }

    public void sendMsg(String msg){
        holder.sendMsg(msg);
    }

    public void makePlayers(){
        String message=holder.getMsg();
        String[] msg=message.split("\n");
        if(msg[0].equals("players/")){
            for(String playerStr:msg){
                String[] strings=playerStr.split(" ");
                if(strings.length==4){
                    Player player=holder.makePlayer(Integer.parseInt(strings[0]),strings[1]);
                    player.setMoney(Integer.parseInt(strings[2]));
                    player.setJetton(Integer.parseInt(strings[3]));
                    addPlayer(player);
                }
            }
        }
    }

    public Player getPlayerById(int id){
        Player player=null;
        for(Player player1:players){
            if(player1.getId()==id) {
                player = player1;
                break;
            }
        }
        return player;
    }

    public Player getPlayerByIdStr(String id){
        return getPlayerById(Integer.parseInt(id));
    }

    public void logPlayer(){
        for(Player player:players)
            Logger.log("#"+player.getId()+" "
                    +player.getName()+" "
                    +player.getMoney()+" "
                    +player.getJetton());
    }

    public boolean isHolder(Player player){
        return holder.isHolder(player.getId());
    }

    public int gameHandCount(){
        return gameHands.size();
    }
}
