package mid_term;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("-------Menu-------");
            System.out.println("1.Add a new student");
            System.out.println("2.Update a student by ID");
            System.out.println("3.Delete a student by ID");
            System.out.println("4.Display all students");
            System.out.println("5.Find the student with the highest GPA");
            System.out.println("6.Exit");
            System.out.print("Choose an option: ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scan.nextLine();
                    System.out.print("Enter Full Name: ");
                    String fullName = scan.nextLine();
                    System.out.print("Enter Date of Birth(yyyy/mm/dd): ");
                    String dateOfBirthString = scan.nextLine();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/DD");
                    Date dateOfBirth = null;
                    try {
                        dateOfBirth = sdf.parse(dateOfBirthString);
                    } catch (ParseException e) {
                        System.out.println("Wrong format");
                    }
                    System.out.print("Enter GPA: ");
                    float gpa = scan.nextFloat();
                    scan.nextLine();
                    System.out.print("Enter major: ");
                    String major = scan.nextLine();
                    Student student = new Student(id, fullName, dateOfBirth, gpa, major);
                    studentList.addStudent(student);
                    System.out.println("Student added");
                    break;

                case 2:
                    System.out.print("Enter student ID to update: ");
                    String updateId = scan.nextLine();
                    Student studentToUpdate = studentList.findStudentById(updateId);
                    if(studentToUpdate != null) {
                        System.out.print("Enter new GPA: ");
                        float newGpa = scan.nextFloat();
                        scan.nextLine();
                        System.out.print("Enter new major: ");
                        String newMajor = scan.nextLine();
                        studentToUpdate.setGPA(newGpa);
                        studentToUpdate.setMajor(newMajor);
                        System.out.println("Student updated.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter student ID to delete: ");
                    String deleteID = scan.nextLine();
                    studentList.deleteStudent(deleteID);
                    break;
                case 4: 
                    studentList.displayAllStudents();
                    break;
                case 5:
                    Student topStudent = studentList.findTopStudent();
                    if(topStudent != null) {
                        System.out.println("The student with the highest GPA is: ");
                        topStudent.displayInfor();
                    }
                    break;
                case 6:
                    System.out.println("Exit.");
                    scan.close();
                    System.exit(6);
                default:
                    System.out.println("Invalid choice. Choice again.");
            }
        }
    }
}
