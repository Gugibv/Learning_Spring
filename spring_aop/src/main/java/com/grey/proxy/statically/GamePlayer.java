package com.grey.proxy.statically;


public class GamePlayer implements IGamePlayer {

    private String name=""; // 玩家名称
    public GamePlayer(String name) {
        this.name = name;
    }


    public void start(){
        System.out.println("登录游戏...");
        System.out.println(name+"开始了游戏");
    }

    public void play()
    {
        System.out.println(name+"被曹贼玩家击杀了");
    }
}
