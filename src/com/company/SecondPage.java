package com.company;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SecondPage extends JPanel {
    private final String[] head = {"ID","NAME","SURNAME","AGE"};
    private JTable table;
    private JScrollPane scroll;

    public SecondPage(){
        setSize(500,500);
        setLayout(null);

        JButton btn = new JButton("BACK");
        btn.setSize(400,30);
        btn.setLocation(50,300);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.ShowMenu();
            }
        });
        add(btn);

        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setRowHeight(30);
        scroll = new JScrollPane(table);
        scroll.setBounds(50,50,400,200);
        add(scroll);

    }

    public void generateTable(ArrayList<Students>students){
        Object[][] data = new Object[students.size()][4];
            try{
            for(int i =0;i<students.size();i++){
                data[i][0] = students.get(i).getId();
                data[i][1] = students.get(i).getName();
                data[i][2] = students.get(i).getSurname();
                data[i][3] = students.get(i).getAge();
            }
            }catch (Exception e){
                e.printStackTrace();
            }
        DefaultTableModel model = new DefaultTableModel(data,head);
        table.setModel(model);

    }
}
