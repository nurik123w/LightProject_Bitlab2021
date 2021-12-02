import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondPage extends Container {
    private String head [] = {"NAME","SURNAME","FACULTY","GROUP"};
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


        scroll  = new JScrollPane(table);
        scroll.setSize(400,200);
        scroll.setLocation(50,80);
        add(scroll);

    }
    public void generateTable(){
        Object data[][] = new Object[MainFrame.indexOfStudents][4];

        for(int i =0;i<MainFrame.indexOfStudents;i++){
            data[i][0] = Main.frame.students[i].getName();
            data[i][1] = Main.frame.students[i].getSurname();
            data[i][2] = Main.frame.students[i].getFaculty();
            data[i][3] = Main.frame.students[i].getGroup();
        }

        DefaultTableModel model = new DefaultTableModel(data, head);
        table.setModel(model);

    }
}