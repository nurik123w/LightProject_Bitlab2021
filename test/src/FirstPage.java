import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPage extends Container {
    String[] faculties = {"Information Technologies","Economics","Mathematics"};

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
        JLabel label2 = new JLabel("FACULTY:");
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
        JComboBox facultiesBox = new JComboBox(faculties);
        facultiesBox.setSize(200,30);
        facultiesBox.setLocation(200,130);
        add(facultiesBox);

        JTextField textField2 = new JTextField();
        textField2.setSize(200,30);
        textField2.setLocation(200,180);
        add(textField2);
        JLabel label3 = new JLabel("GROUP:");
        label3.setSize(200,30);
        label3.setLocation(100,180);
        add(label3);

        JButton button = new JButton("ADD");
        button.setSize(150,30);
        button.setLocation(250,350);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                String surname = textField1.getText();
                String group =  textField2.getText();
                String faculty = (String) facultiesBox.getSelectedItem();
                if(!name.equals("")){
                    Student s = new Student(name,surname,group,faculty);

                    Main.frame.addStudent(s);
                    textField.setText("");
                    textField1.setText("");
                    textField2.setText("");
                    facultiesBox.getSelectedIndex();
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