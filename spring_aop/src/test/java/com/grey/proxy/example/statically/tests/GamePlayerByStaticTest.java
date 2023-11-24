package com.grey.proxy.example.statically.tests;

import com.grey.proxy.example.statically.GameProxyPlayer;
import com.grey.proxy.example.statically.IGamePlayer;
import org.junit.Test;


public class GamePlayerByStaticTest {

    @Test
    public void test(){
        IGamePlayer gamePlayer=new GameProxyPlayer("徐庶");

        gamePlayer.start();
        gamePlayer.play();
    }
}
