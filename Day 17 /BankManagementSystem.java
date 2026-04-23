import java.util.*;

class Account {
    int accNumber;
    String name;
    double balance;

    Account(int accNumber, String name, double balance) {
        this.accNumber = accNumber;
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    void display() {
        System.out.println("Acc No: " + accNumber + ", Name: " + name + ", Balance: " + balance);
    }
}

public class BankManagementSystem {

    static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Search Account");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: viewAccounts(); break;
                case 3: depositMoney(); break;
                case 4: withdrawMoney(); break;
                case 5: searchAccount(); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid Choice!");
            }
        }
    }

    static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        accounts.add(new Account(accNo, name, balance));
        System.out.println("Account Created Successfully!");
    }

    static void viewAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No Accounts Found!");
            return;
        }

        for (Account acc : accounts) {
            acc.display();
        }
    }

    static Account findAccount(int accNo) {
        for (Account acc : accounts) {
            if (acc.accNumber == accNo) {
                return acc;
            }
        }
        return null;
    }

    static void depositMoney() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Account acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();
            acc.deposit(amount);
        } else {
            System.out.println("Account Not Found!");
        }
    }

    static void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Account acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();
            acc.withdraw(amount);
        } else {
            System.out.println("Account Not Found!");
        }
    }

    static void searchAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.display();
        } else {
            System.out.println("Account Not Found!");
        }
    }
}
