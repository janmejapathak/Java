import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeManager manager = new EmployeeManager();

        manager.loadData();

        while (true) {

            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Save Data");
            System.out.println("6. Exit");

            System.out.print("Choose: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();

                    manager.addEmployee(new Employee(id, name, dept, salary));

                    break;

                case 2:

                    manager.viewEmployees();

                    break;

                case 3:

                    System.out.print("Enter ID: ");

                    manager.searchEmployee(sc.nextInt());

                    break;

                case 4:

                    System.out.print("Enter ID: ");

                    manager.deleteEmployee(sc.nextInt());

                    break;

                case 5:

                    manager.saveData();

                    break;

                case 6:

                    manager.saveData();

                    System.out.println("Thank You.");

                    sc.close();

                    return;

                default:

                    System.out.println("Invalid Choice.");

            }

        }

    }

}
