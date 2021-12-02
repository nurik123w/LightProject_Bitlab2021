package com.company;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;


public class Mainframe extends JFrame {
    protected MainMenu menu;
    protected FirstPage firstPage;
    protected SecondPage secondPage;
    protected  Socket socket;
    protected ObjectOutputStream outputStream;
    protected ObjectInputStream inputStream;


    public Mainframe() throws IOException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("STUDENT APPLICATION");
        setSize(500,500);
        menu = new MainMenu();
        menu.setVisible(true);
        add(menu);
        firstPage = new FirstPage();
        firstPage.setVisible(false);
        add(firstPage);
        secondPage = new SecondPage();
        secondPage.setVisible(false);
        add(secondPage);
        socket = new Socket("127.0.0.1",5555);
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        inputStream = new ObjectInputStream(socket.getInputStream());
    }
    public void ShowMenu(){
        menu.setVisible(true);
        firstPage.setVisible(false);
        secondPage.setVisible(false);
    }
    public void ShowFirst(){
        menu.setVisible(false);
        firstPage.setVisible(true);
        secondPage.setVisible(false);
    }
    public void ShowSecond(){
        menu.setVisible(false);
        firstPage.setVisible(false);
        secondPage.setVisible(true);
    }
    public ArrayList<Students> getStudentsFromServer() throws IOException, ClassNotFoundException {
        Main.frame.outputStream.writeObject("2");
        ArrayList<Students>students =(ArrayList<Students>) Main.frame.inputStream.readObject();
        return students;
    }
}
