package com.grey.streamCorruptedException.test;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

//会报错： StreamCorruptedException: invalid stream header: 7371007E
public class Server {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        ServerSocket serverSocket = new ServerSocket(1234);

        System.out.println("start. . .");
        Socket clientSocket = serverSocket.accept();

        //用clientSocket的输入流创建对象输入流objInput
        ObjectInputStream objInput = new ObjectInputStream(clientSocket.getInputStream());
        User user = (User)objInput.readObject();
        System.out.println(user.GetName());
        System.out.println(user.GetAge());

        //用clientSocket的输入流创建对象输入流objInput2
        ObjectInputStream objInput2 = new ObjectInputStream(clientSocket.getInputStream());
        user = (User)objInput2.readObject();
        System.out.println(user.GetName());
        System.out.println(user.GetAge());


        clientSocket.close();
        serverSocket.close();
    }

}
