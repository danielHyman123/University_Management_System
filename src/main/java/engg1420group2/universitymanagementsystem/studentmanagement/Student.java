package engg1420group2.universitymanagementsystem.studentmanagement;
import java.util.ArrayList;
import java.util.Random;
public class Student {

    private String name;
    private String id;
    private String address;
    private String phone;
    private String email;
    //private profile picture
    private double tution;
    //grades
    //current semester
    //registered classes
    //subjects registerd
    //academic level
    private String thesis_title;
    //progress


    public Student() {


    }

    public Student(String name, String address, String phone, String email, String thesis_title) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.thesis_title = thesis_title;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getThesis_title() {
        return thesis_title;
    }







}
