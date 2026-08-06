import java.io.*;
import java.util.ArrayList;

public class EmployeeManager {

    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee e) {
        employees.add(e);
        System.out.println("Employee Added Successfully.");
    }

    public void viewEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No Employee Found.");
            return;
        }

        for (Employee e : employees) {
            System.out.println("-------------------------");
            System.out.println(e);
        }
    }

    public void searchEmployee(int id) {

        for (Employee e : employees) {

            if (e.getId() == id) {
                System.out.println(e);
                return;
            }

        }

        System.out.println("Employee Not Found.");
    }

    public void deleteEmployee(int id) {

        Employee remove = null;

        for (Employee e : employees) {

            if (e.getId() == id) {
                remove = e;
                break;
            }

        }

        if (remove != null) {
            employees.remove(remove);
            System.out.println("Employee Deleted.");
        } else {
            System.out.println("Employee Not Found.");
        }

    }

    public void saveData() {

        try {

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employees.dat"));

            out.writeObject(employees);

            out.close();

            System.out.println("Data Saved.");

        } catch (Exception e) {

            System.out.println("Error Saving Data.");

        }

    }

    @SuppressWarnings("unchecked")
    public void loadData() {

        try {

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("employees.dat"));

            employees = (ArrayList<Employee>) in.readObject();

            in.close();

            System.out.println("Data Loaded.");

        } catch (Exception e) {

            System.out.println("No Previous Data Found.");

        }

    }

}
