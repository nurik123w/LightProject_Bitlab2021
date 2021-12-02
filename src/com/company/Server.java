package com.company;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket socketServer = new ServerSocket(5555);
            while (true){
                Socket socket = socketServer.accept();
                System.out.println("smone joined to the server");
                ClientHandler ch = new ClientHandler(socket);
                ch.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
