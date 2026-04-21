import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    String getGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 50) return "C";
        else return "Fail";
    }
}

public class StudentManager {
    static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent(Scanner sc) {
        System.out.print("Enter name: ");
        String name = sc.next();

        System.out.print("Enter marks: ");
        int marks = sc.nextInt();

        students.add(new Student(name, marks));
        System.out.println("Student added successfully!\n");
    }

    public static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.\n");
            return;
        }

        for (Student s : students) {
            System.out.println("Name: " + s.name + 
                               ", Marks: " + s.marks + 
                               ", Grade: " + s.getGrade());
        }
        System.out.println();
    }

    public static void findTopper() {
        if (students.isEmpty()) {
            System.out.println("No data available.\n");
            return;
        }

        Student topper = students.get(0);

        for (Student s : students) {
            if (s.marks > topper.marks) {
                topper = s;
            }
        }

        System.out.println("Topper: " + topper.name + 
                           " with marks: " + topper.marks + "\n");
    }

    public static void averageMarks() {
        if (students.isEmpty()) {
            System.out.println("No data available.\n");
            return;
        }

        int sum = 0;
        for (Student s : students) {
            sum += s.marks;
        }

        double avg = (double) sum / students.size();
        System.out.println("Average Marks: " + avg + "\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Find Topper");
            System.out.println("4. Average Marks");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    findTopper();
                    break;
                case 4:
                    averageMarks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!\n");
            }
        }
    }
}
