/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assessment1;

/**
 *
 * @author Sultan
 */
import java.util.ArrayList;
import java.util.Scanner;

public class IndustryPlacement {

    final int ENTER_STUDENT = 1;  
    final int VIEW_ALL_STUDENT = 2; 
    final int EXIT = 3;

    private ArrayList<Student> studentList = new ArrayList<>();

    private int getMenuItem() {
        Scanner inputMenuChoice = new Scanner(System.in);

        System.out.println("\nPlease select from the following");
        System.out.println(ENTER_STUDENT + ". Enter student details");       
        System.out.println(VIEW_ALL_STUDENT + ". View all students");
        System.out.println(EXIT + ". Exit the application");
        System.out.print("\nEnter choice ==> ");

        String choice = inputMenuChoice.nextLine();
        
        while (choice.equals("") || !isStringNumeric(choice)) {
            System.out.println("Error - Menu selection cannot be blank and must be numeric");
            System.out.print("Enter choice ==> ");
            choice = inputMenuChoice.nextLine();
        }
        return Integer.parseInt(choice);
    }

    private boolean isStringNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isFloatNumeric(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isCampusValid(String input) {
        return input.equalsIgnoreCase("CNS") || input.equalsIgnoreCase("ROK") ||
               input.equalsIgnoreCase("BNE") || input.equalsIgnoreCase("MEL") ||
               input.equalsIgnoreCase("SYD") || input.equalsIgnoreCase("Online");
    }

    private boolean isCourseValid(String input) {
        return input.equalsIgnoreCase("CQ18") || input.equalsIgnoreCase("CG99") ||
               input.equalsIgnoreCase("CC53") || input.equalsIgnoreCase("CC54");
    }

    private boolean isNumberValid(String input, int min, int max) {
        if (isStringNumeric(input)) {
            int inputInt = Integer.parseInt(input);
            return inputInt >= min && inputInt <= max;
        }
        return false;
    }

    private String capitalizeName(String name) {
        String[] parts = name.split(" ");
        StringBuilder formattedName = new StringBuilder();
        for (String part : parts) {
            if (part.length() > 0) {
                formattedName.append(part.substring(0, 1).toUpperCase())
                             .append(part.substring(1).toLowerCase()).append(" ");
            }
        }
        return formattedName.toString().trim();
    }

    private void processOrders() {
        System.out.println("Welcome to the Industry Placement System!");
        System.out.println("Created by: Sultan Zahid, Student ID: 12274082");

        int choice = getMenuItem();

        while (choice != EXIT) {
            switch (choice) {
                case ENTER_STUDENT:
                    enterStudent();
                    break;             
                case VIEW_ALL_STUDENT:
                    viewAllStudent();
                    break;             
                default:
                    System.out.println("Error - Invalid menu choice");
            }
            choice = getMenuItem();
        }

        System.out.println("Thanks for using the Industry Placement System!");
        System.out.println("Created by Sultan Zahid, Student ID: 12274082");
    }

    private void enterStudent() {
        Scanner inText = new Scanner(System.in);

        String input;
        do {
            System.out.print("Please enter student ID: (must be an 8-digit integer) ");
            input = inText.nextLine();

            if (input.equals("") || !isStringNumeric(input) || !(input.length() == 8)) {
                System.out.println("Error, Student ID must be an 8-digit number and cannot be blank");
            }

        } while (input.equals("") || !isStringNumeric(input) || !(input.length() == 8));

        int studentID = Integer.parseInt(input);

        if (findStudent(studentID) != -1) {
            System.out.println("Error, This student ID already exists.");
            return;
        }

        System.out.print("Please enter the student's full name: ");
        String fullName = capitalizeName(inText.nextLine());

        do {
            System.out.print("Please enter campus (CNS, ROK, BNE, MEL, SYD, Online): ");
            input = inText.nextLine().toUpperCase();
            if (!isCampusValid(input)) {
                System.out.println("Error - Invalid campus. Please try again.");
            }
        } while (!isCampusValid(input));

        String campus = input;

        do {
            System.out.print("Please enter course code (CQ18, CG99, CC53, CC54): ");
            input = inText.nextLine().toUpperCase(); // Convert to uppercase
            if (!isCourseValid(input)) {
                System.out.println("Error, Incorrect course code. Please try again.");
            }
        } while (!isCourseValid(input));

        String courseCode = input;

        do {
            System.out.print("Please enter number of units completed (1-24): ");
            input = inText.nextLine();    
            if (input.equals("") || !isStringNumeric(input) || Integer.parseInt(input) < 1 || Integer.parseInt(input) > 24) {
                System.out.println("Error - Number of units must be between 1 and 24 and cannot be blank.");
            }
        } while (input.equals("") || !isStringNumeric(input) || Integer.parseInt(input) < 1 || Integer.parseInt(input) > 24);

        int unitsCompleted = Integer.parseInt(input);

        do {
            System.out.print("Please enter GPA (0.0 - 7.0): ");
            input = inText.nextLine();
            if (!isFloatNumeric(input) || Float.parseFloat(input) < 0.0 || Float.parseFloat(input) > 7.0) {
                System.out.println("Error, Please enter GPA between 0.0 and 7.0.");
            }
        } while (!isFloatNumeric(input) || Float.parseFloat(input) < 0.0 || Float.parseFloat(input) > 7.0);

        float gpa = Float.parseFloat(input);

        Student newStudent = new Student(studentID, fullName, campus, courseCode, unitsCompleted, gpa);

        studentList.add(newStudent);

        System.out.println("Student added successfully:");
        System.out.println(newStudent.toString());
    }

    private int findStudent(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentID() == id) {
                return i;
            }
        }
        return -1;
    }

    private void viewAllStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No record found");
        } else {
            for (Student student : studentList) {
                System.out.println(student.toString());
                System.out.println("----------------------------");
            }
        }
    }

    public static void main(String[] args) {
        IndustryPlacement app = new IndustryPlacement();
        app.processOrders();
    }
}