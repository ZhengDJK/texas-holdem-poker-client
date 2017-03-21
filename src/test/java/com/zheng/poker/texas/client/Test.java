package com.zheng.poker.texas.client;

import com.zheng.poker.texas.*;
import com.zheng.poker.texas.model.cards.Card;
import com.zheng.poker.texas.model.cards.Deck;

import java.util.Stack;

/**
 * Created by zheng on 2016/12/8.
 */
public class Test {

    public static void main(String[] args){
        com.zheng.poker.texas.Play.main(null);
        int qqq=(int)(1.5*2);
        System.out.println(qqq);
        Deck deck=new Deck();
        System.out.println(deck.removeTopCard());
        String test="a b c ";
        StringBuilder stringBuilder=new StringBuilder(test);
        String[] s=test.split(" ");
        System.out.println(s.length);
        for(String str:s)
            System.out.print(str);
        String string="60793";
        int id=Integer.parseInt(string);
        System.out.println(id);

        Stack<Integer> si=new Stack<Integer>();
        for(int i=0;i<5;i++)
            si.add(i);
        for(int i:si)
            System.out.print(i);
        Card card=Card.fromString("♥6");
        System.out.print(card);

    }
}
