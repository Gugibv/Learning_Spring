package com.grey.proxy.statically.tests;

import com.grey.proxy.statically.GameProxyPlayer;
import com.grey.proxy.statically.IGamePlayer;
import org.junit.Test;


public class GamePlayerByStaticTest {

    @Test
    public void test(){
        IGamePlayer gamePlayer=new GameProxyPlayer("徐庶");

        gamePlayer.start();
        gamePlayer.play();
    }
}
