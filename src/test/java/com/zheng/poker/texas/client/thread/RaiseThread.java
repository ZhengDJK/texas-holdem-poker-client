package com.zheng.poker.texas.client.thread;

import com.zheng.poker.texas.Play;
import com.zheng.poker.texas.client.play.RaisePlay;
import com.zheng.poker.texas.utils.Sleep;

/**
 * Created by zheng on 2017/1/4.
 */
public class RaiseThread extends Thread {
    public void run(){
        Sleep.sleep(500);
        RaisePlay.main(null);
    }
}
