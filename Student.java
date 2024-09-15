package mid_term;

import java.util.Date;

public class Student extends Person {

    private float GPA;
    private String major;

    public Student(String id, String fullName, Date dateOfBirth, float GPA, String major) {
        super(id, fullName, dateOfBirth);
        this.GPA = GPA;
        this.major = major;
    }
    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void displayInfor() {
        System.out.println("ID: " + id + "; FullName: " + fullName + "; Date Of Birth(yyyy/mm/dd): " + dateOfBirth + "; GPA: " + "; Major:" + major);
    }
}
