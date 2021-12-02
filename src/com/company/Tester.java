package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try{
            Socket socket = new Socket("127.0.0.1",5555);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            while(true){
                System.out.println("""
                        press 1 add
                        press 2 list
                        press 0 exit
                        """);
                int choice = scan.nextInt();
                if(choice==1){
                    outputStream.writeObject("1");
                    System.out.println("name");
                    String name = scan.next();
                    System.out.println("surname");
                    String surname = scan.next();
                    System.out.println("age");
                    int age = scan.nextInt();
                    System.out.println("ok");
                    Students u = new Students(null, name, surname, age);
                    outputStream.writeObject(u);
                }else if(choice==2){
                    outputStream.writeObject("2");
                    ArrayList<Students> students=null;
                    students = (ArrayList<Students>) inputStream.readObject();
                    for (Students s : students) {
                        System.out.println(s);
                    }
                    System.out.println("test "+students.get(1));
                }else if (choice==0){
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
