import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter Name: ");
            String name = sc.next();
            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();

            list.add(new Student(name, marks));
        }

        System.out.println("\nStudent Records:");
        for (Student s : list) {
            System.out.println(s.name + " - " + s.marks);
        }

        sc.close();
    }
}
