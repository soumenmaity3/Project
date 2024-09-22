import java.util.*;
import java.io.*;

class School {
    int size = 10;
    int top = -1;
    long[] school = new long[size];
    String name;
    long id;
    long mobile;

    void fileCreate() throws Exception {
        FileOutputStream fos = new FileOutputStream("School.txt", true);
        fos.write(("Student name- " + name + "\nStudent ID- " + id + "\nMobile number is- " + mobile + "\n\n")
                .getBytes());
        fos.close();
    }

    static boolean isValidMobileNumber(long mobileNumber) {
        String mobileStr = Long.toString(mobileNumber);
        return mobileStr.length() == 10;
    }

    boolean isStudentExists(long studentId) {
        // int n=top+1;
        for (int i = 0; i <= top; i++) {
            if (school[i] == studentId) {
                return true;
            }
        }
        return false;
    }

    void addStudent() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the student name: ");
        name = scan.nextLine();
        System.out.println("Enter Student Id (ID is always number): ");
        id = scan.nextLong();
        if (isStudentExists(id)) {
            System.out.println("This student already exists.");
        } else {
            if (top == size - 1) {
                System.out.println("Your school is full.");
            } else {
                System.out.println("Enter Student's mobile number: ");
                mobile = scan.nextLong();
                if (isValidMobileNumber(mobile)) {
                    System.out.println("Student added successfully.");
                    top++;
                    school[top] = id;
                    fileCreate();
                } else {
                    System.out.println("Invalid mobile number. It must be 10 digits long. Try again.");
                }
            }

        }
    }

    void searchStudent() {
        if (top == -1) {
            System.out.println("Your school is empty. please add student first.");
        } else {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the student ID to search (ID is always number): ");
            long studentId = scan.nextLong();
            // String studentName = scan.next();
            for (int i = 0; i <= top; i++) {
                if (studentId == school[top]) {
                    System.out
                            .println("Student information is- " + "\nName- " + name + "\nID- " + id + "\nMobile- " + mobile);
                } else {
                    System.out.println("We can't find this student here. Please try again later.");
                }
            }
        }
    }

    void deleteStudent() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the student ID to delete: ");
        long studentId = scan.nextLong();
        boolean deleted = false;
    
        for (int i = 0; i <= top; i++) {
            if (studentId == school[i]) {
                // Shift elements to the left to remove the student
                for (int j = i; j < top; j++) {
                    school[j] = school[j + 1];
                }
                top--;  // Decrease the count of students
                deleted = true;
                System.out.println("Student deleted successfully.");
                break;  // Exit loop after deletion
            }
        }
        
        if (deleted==true) {
            updateFile();  // Call method to update the file after deletion
        } else {
            System.out.println("No student found with ID: " + studentId);
        }
    }
    
    void updateFile() {
        try {
            FileOutputStream fos = new FileOutputStream("School.txt");
            for (int i = 0; i <= top; i++) {
                // Write each student's details back to the file
                fos.write(("Student ID: " + school[i] + "\n").getBytes());
            }
            fos.close();
        } catch (Exception e) {
            System.out.println("Error updating file: " + e.getMessage());
        }
    }
    

    public static void main(String[] args) throws Exception {
        School student = new School();
        int ch;
        System.out.println("You have 100 seats in your school for students");
        student.fileCreate();
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("1. Add a new student");
            System.out.println("2. Search for a student");
            System.out.println("3.Delete a student");
            System.out.println("4.Exit");
            System.out.println("Choose an option:");
            ch = scan.nextInt();
            switch (ch) {
                case 1:
                    student.addStudent();
                    break;
                case 2:
                    student.searchStudent();
                    break;
                case 3:
                    student.deleteStudent();
                    break;
                case 4:
                    System.out.println("Exit......");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (ch != 5);
    }
}