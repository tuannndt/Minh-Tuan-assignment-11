package mid_term;

import java.util.ArrayList;

public class StudentList {

    private final ArrayList<Student> studentList;

    public StudentList() {
        studentList = new ArrayList<>();
    }
    public void addStudent(Student student) {
        studentList.add(student);
    }
    public void deleteStudent(String id) {
        for(int i=0;i<studentList.size();i++) {
            if(studentList.get(i).getId().equals(i)) {
                studentList.remove(i);
                System.out.println("Student with ID " + id  + "has been delete.");
                return;
            }
        }
        System.out.println("Student with ID " + id  + "not found.");
    }
    public Student findStudentById(String id) {
        for(Student student : studentList) {
            if(student.getId().equals(id)) {
                return student;
            }
        }
        System.out.println("Student with ID " + id  +"not found.");
        return null;
    }
    public void displayAllStudents() {
        if(studentList.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for(Student student : studentList) {
                student.displayInfor();
            }
        }
    }
    public Student findTopStudent() {
        if(studentList.isEmpty()) {
            System.out.println("No students available.");
            return null;
        }
        Student topStudent = studentList.get(0);
        for(Student student : studentList) {
            if(student.getGPA() > topStudent.getGPA()) {
                topStudent = student;
            }
        }
        return topStudent;
    }
}
