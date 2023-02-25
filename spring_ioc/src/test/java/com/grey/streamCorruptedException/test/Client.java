package com.grey.streamCorruptedException.test;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("127.0.0.1", 1234);
        ObjectOutputStream objOutput = new ObjectOutputStream(client.getOutputStream());
        //用同一输出流发送两个对象
        User user = new User("小明", 20);
        objOutput.writeObject(user);
        User user1 = new User("小红", 10);
        objOutput.writeObject(user1);
        client.close();
    }


}
