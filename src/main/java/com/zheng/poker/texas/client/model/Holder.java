package com.zheng.poker.texas.client.model;

import com.zheng.poker.texas.model.cards.Card;
import com.zheng.poker.texas.utils.Logger;
import com.zheng.poker.texas.utils.MySocket;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zheng on 2016/12/8.
 */
public class Holder {
    private final Player player;
    private List<Card> holdCards;
    private MySocket socket;

    public Holder(String name){
        try {
            socket=new MySocket(new Socket("localhost", 8888));
        } catch (IOException e) {
            e.printStackTrace();
        }
        sendMsg(name);
        this.player=new Player(socket.getLocalPort(),name);
    }

    public boolean isHolder(int id){
        return this.player.getId()==id;
    }

    public List<Card> getHoldCards() {
        return holdCards;
    }

    public String getMsg(){
        String msg = socket.getMsg();
        Logger.log(msg);
        return msg;
    }

    public void sendMsg(String msg){
        socket.sendMsg(msg);
    }

    public Player makePlayer(int id,String name){
        if(isHolder(id))
            return player;
        else
            return new Player(id,name);
    }

    public Player getPlayer() {
        return player;
    }

    public void setHoldCards(String cardString){
        String[] cards=cardString.split("\n");
        holdCards=new ArrayList<Card>(Arrays.asList(Card.fromString(cards[1]),
                Card.fromString(cards[2])));
    }

    public void stop(){
        socket.close();
    }

    public void setName(String name){
        player.setName(name);
    }
}
