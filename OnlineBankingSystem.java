import java.io.*;
import java.util.Scanner;

public class OnlineBankingSystem {
    private String username;
    private String password;
    private double balance;

    public OnlineBankingSystem(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OnlineBankingSystem currentUser = null;
        int choice;

        while (true) {
            System.out.println("\nOnline Banking System");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    currentUser = login();
                    if (currentUser != null) {
                        int loggedInChoice;
                        do {
                            System.out.println("\n1. View Balance");
                            System.out.println("2. Deposit");
                            System.out.println("3. Withdraw");
                            System.out.println("4. Logout");
                            System.out.print("Enter your choice: ");
                            loggedInChoice = sc.nextInt();

                            switch (loggedInChoice) {
                                case 1:
                                    currentUser.viewBalance();
                                    break;
                                case 2:
                                    currentUser.deposit();
                                    break;
                                case 3:
                                    currentUser.withdraw();
                                    break;
                                case 4:
                                    System.out.println("Logging out...");
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }
                        } while (loggedInChoice != 4);
                    } else {
                        System.out.println("Invalid login credentials. Please try again.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to create a new account
    public static void createAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        double balance = 0.0;

        OnlineBankingSystem newUser = new OnlineBankingSystem(username, password, balance);
        newUser.saveUserData();
        System.out.println("Account created successfully!");
    }

    // Method to handle user login
    public static OnlineBankingSystem login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        OnlineBankingSystem user = loadUserData(username);
        if (user != null && user.password.equals(password)) {
            System.out.println("Login successful!");
            return user;
        }
        return null;
    }

    // Method to view current balance
    public void viewBalance() {
        System.out.printf("Current balance: Rs. %.2f\n", this.balance);
    }

    // Method to deposit money
    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        if (amount > 0) {
            this.balance += amount;
            saveUserData();
            System.out.printf("Deposit successful! New balance: Rs. %.2f\n", this.balance);
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
    }

    // Method to withdraw money
    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            saveUserData();
            System.out.printf("Withdrawal successful! New balance: Rs. %.2f\n", this.balance);
        } else {
            System.out.println("Invalid amount or insufficient balance. Please try again.");
        }
    }

    // Method to save user data to a file
    public void saveUserData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.username + ".txt"))) {
            writer.write(this.username + "\n");
            writer.write(this.password + "\n");
            writer.write(this.balance + "\n");
        } catch (IOException e) {
            System.out.println("Error saving user data.");
        }
    }

    // Method to load user data from a file
    public static OnlineBankingSystem loadUserData(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(username + ".txt"))) {
            String uname = reader.readLine();
            String pwd = reader.readLine();
            double balance = Double.parseDouble(reader.readLine());
            return new OnlineBankingSystem(uname, pwd, balance);
        } catch (IOException e) {
            System.out.println("User not found or error loading data.");
            return null;
        }
    }
}
