package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class MainMenu extends Container {
    protected JButton first;
    protected JButton second;
    protected JButton third;

    public MainMenu  () throws IOException {
        setSize(500,500);
        setLayout(null);
        first = new JButton("ADD STUDENT");
        first.setSize(200,30);
        first.setLocation(150,100);
        add(first);
        first.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.frame.outputStream.writeObject("1");
                } catch (Exception w){
                   w.printStackTrace();
                }
                Main.frame.ShowFirst();
            }
        });
        second = new JButton("LIST STUDENTS");
        second.setSize(200,30);
        second.setLocation(150,150);
        add(second);
        second.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.frame.outputStream.writeObject("2");
                    Main.frame.secondPage.generateTable(Main.frame.getStudentsFromServer());
                    Main.frame.ShowSecond();
                } catch (Exception s) {
                    s.printStackTrace();
                }
            }
        });
        third = new JButton("EXIT");
        third.setSize(200,30);
        third.setLocation(150,200);
        add(third);
        third.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

