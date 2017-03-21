package com.zheng.poker.texas.client.model;

/**
 * Created by zheng on 2016/12/8.
 */
public class Player {
    private int money;
    private int jetton;
    private final int id;
    private String name;

    public Player(int id,String name){
        this.id=id;
        this.name=name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getJetton() {
        return jetton;
    }

    public void setJetton(int jetton) {
        this.jetton = jetton;
    }

    public void addJetton(int amount){
        jetton+=amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
