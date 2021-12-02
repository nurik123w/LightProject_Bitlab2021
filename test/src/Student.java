public class Student {
    int id;
    String name;
    String surname;
    String faculty;
    String group;
    static int count=0;




    public  Student(){}
    public Student(String name, String surname, String faculty, String group) {
        this.id = count;
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
        this.group = group;
        count++;
    }
    public  String setName(String name){
        return  this.name = name;
    }
    public  String getName(){
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student:  " +
                "id: " + id +
                ", name: " + name +
                ", surname: " + surname +
                ", faculty: " + faculty +
                ", group: " + group;
    }

}