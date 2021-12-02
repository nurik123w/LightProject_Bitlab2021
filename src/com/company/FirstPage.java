package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FirstPage extends Container {

    public FirstPage(){
        setSize(500,500);
        setLayout(null);
        JLabel label = new JLabel("NAME:");
        label.setSize(200,30);
        label.setLocation(100,30);
        add(label);
        JLabel label1 = new JLabel("SURNAME:");
        label1.setSize(200,30);
        label1.setLocation(100,80);
        add(label1);
        JLabel label2 = new JLabel("AGE:");
        label2.setSize(200,30);
        label2.setLocation(100,130);
        add(label2);

        JTextField textField = new JTextField();
        textField.setSize(200,30);
        textField.setLocation(200,30);
        add(textField);

        JTextField textField1 = new JTextField();
        textField1.setSize(200,30);
        textField1.setLocation(200,80);
        add(textField1);

        JTextField textField2 = new JTextField();
        textField2.setSize(200,30);
        textField2.setLocation(200,130);
        add(textField2);

        JButton button = new JButton("ADD");
        button.setSize(150,30);
        button.setLocation(250,350);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                String surname = textField1.getText();
                int age = Integer.parseInt(textField2.getText());

                if(!name.equals("")){
                    Students s = new Students(null,name,surname,age);
                    try {
                        Main.frame.outputStream.writeObject(s);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    textField.setText("");
                    textField1.setText("");
                    textField2.setText("");
                }
            }
        });
        add(button);
        JButton button1 = new JButton("BACK");
        button1.setSize(150,30);
        button1.setLocation(100,350);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.ShowMenu();
            }
        });
        add(button1);
    }
}
