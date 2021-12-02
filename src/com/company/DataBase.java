package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DataBase {
    private Connection connect;
    public DataBase(){}

    public void connectToDB() {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useUnicode=true&serverTimezone=UTC","root", "");
         }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Students> getAllStudents(){
        ArrayList<Students>students=new ArrayList<>();
        try{
            PreparedStatement pt = connect.prepareStatement("SELECT * FROM students");
            ResultSet rs = pt.executeQuery();
            while(rs.next()){
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                students.add(new Students(id,name,surname,age));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }
    public void addStudent(Students s){
        try{
            PreparedStatement pt = connect.prepareStatement("INSERT INTO students(name,surname,age)values(?,?,?)");
            pt.setString(1,s.getName());
            pt.setString(2,s.getSurname());
            pt.setInt(3,s.getAge());
            pt.executeUpdate();
            pt.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
