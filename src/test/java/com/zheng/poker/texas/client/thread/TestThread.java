package com.zheng.poker.texas.client.thread;

import com.zheng.poker.texas.Play;
import com.zheng.poker.texas.client.play.TestPlay;
import com.zheng.poker.texas.utils.Sleep;

/**
 * Created by zheng on 2017/1/4.
 */
public class TestThread extends Thread {
    public void run(){
        Sleep.sleep(500);
        TestPlay.main(null);
    }
}
