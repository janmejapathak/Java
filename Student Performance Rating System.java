import java.util.Scanner;

public class StudentPerformance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Student Name: ");
        String name = sc.nextLine();

        System.out.print("Marks (%): ");
        double marks = sc.nextDouble();

        System.out.print("Attendance (%): ");
        double attendance = sc.nextDouble();

        System.out.print("Assignment (%): ");
        double assignment = sc.nextDouble();

        double score = marks * 0.6 + attendance * 0.2 + assignment * 0.2;

        String rating = score >= 90 ? "Excellent" :
                        score >= 75 ? "Very Good" :
                        score >= 60 ? "Good" :
                        score >= 40 ? "Average" : "Poor";

        System.out.println("\n--- Performance Report ---");
        System.out.println("Student : " + name);
        System.out.printf("Score   : %.2f%%\n", score);
        System.out.println("Rating  : " + rating);

        sc.close();
    }
}
