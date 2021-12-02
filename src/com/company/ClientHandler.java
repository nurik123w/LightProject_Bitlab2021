package com.company;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread {
   Socket socket;
   ObjectInputStream inputStream;
   ObjectOutputStream outputStream;
   DataBase db =new DataBase();

   public ClientHandler(Socket socket) throws IOException {
       this.socket = socket;
       inputStream = new ObjectInputStream(socket.getInputStream());
       outputStream = new ObjectOutputStream(socket.getOutputStream());
       db.connectToDB();
   }

    public void run(){
        try{
            while(true) {
                String request = (String) inputStream.readObject();
                if (request.equals("1")) {
                    Students u = null;
                    u = (Students) inputStream.readObject();
                    db.addStudent(u);
                } else if (request.equals("2")) {
                    ArrayList<Students> student = db.getAllStudents();
                    outputStream.writeObject(student);
                }
            }
        }catch (Exception e){
            System.out.println("disconnected");
        }
    }
}
