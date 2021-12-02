import javax.swing.*;
public class MainFrame extends JFrame {
    protected MainMenu menu;
    protected FirstPage firstPage;
    protected SecondPage secondPage;
    protected Student[] students = new Student[100];
    protected static  int indexOfStudents = 0;
    public void addStudent(Student students){
        this.students[indexOfStudents] =students;
        indexOfStudents++;
    }
    public MainFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("STUDENT APPLICATION");
        setSize(500,500);
        menu = new MainMenu();
        menu.setVisible(true);
        add(menu);
        firstPage = new FirstPage();
        firstPage .setVisible(false);
        add(firstPage );
        secondPage = new SecondPage();
        secondPage.setVisible(false);
        add(secondPage);

    }
    public void ShowFirst(){
        menu.setVisible(false);
        firstPage.setVisible(true);
    }
    public void ShowMenu(){
        menu.setVisible(true);
        firstPage.setVisible(false);
        secondPage.setVisible(false);
    }
    public void ShowSecond(){
        menu.setVisible(false);
        firstPage.setVisible(false);
        secondPage.setVisible(true);
    }
    public SecondPage getSecondPage(){
        return secondPage;
    }
}
