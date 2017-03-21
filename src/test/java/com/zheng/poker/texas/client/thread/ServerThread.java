package com.zheng.poker.texas.client.thread;

import com.zheng.poker.texas.Play;

/**
 * Created by zheng on 2017/1/4.
 */
public class ServerThread extends Thread {
    public void run(){
        Play.main(null);
    }
}
