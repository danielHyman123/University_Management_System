package engg1420group2.universitymanagementsystem.studentmanagement;
import java.util.ArrayList;
import java.util.Random;

//Student Class
//This should be pretty obvious what things do
public class Student extends User {

  private static String studentID;
  private static int IDNum = 20250000;

  private String address;
  private String phone;
  private String acdemicLvl;
  private String semester;
  private String thesis;
  private String progress;

  private ArrayList<String> courses;

  public Student(String name, String password, String email, String address, String phone, String acdemicLvl, String semester, String thesis, String progress) {
      super(name, password, email);
      this.address = address;
      this.phone = phone;
      this.acdemicLvl = acdemicLvl;
      this.semester = semester;

      studentID = "S" + (IDNum + 1);

      this.thesis = thesis;

      if (thesis == null) {
          progress = "0%";

      } else {
          progress = progress + "%";
      }
  }

  public Student() {
      super("John Doe", "default123", "j_doe@example.edu");
      address = "123 Main St.";
      phone = "555-5555";
      acdemicLvl = "Undergraduate";
      semester = "Fall 2025";
      studentID = "S" + (IDNum + 1);
      thesis = null;

      if (thesis == null) {
          progress = "0%";
      }

  }

  /*
  Finish everything going on with the courses and that array list
   */

  public String getAddress() {
      return address;
  }

  public void setAddress(String address) {
      this.address = address;
  }

  public String getPhone() {
      return phone;
  }

  public void setPhone(String phone) {
      this.phone = phone;
  }

  public String getAcdemicLvl() {
      return acdemicLvl;
  }

  public void setAcdemicLvl(String acdemicLvl) {
      this.acdemicLvl = acdemicLvl;
  }

  public String getSemester() {
      return semester;
  }

  public void setSemester(String semester) {
      this.semester = semester;
  }

  public String getThesis() {
      return thesis;
  }

  public void setThesis(String thesis) {
      this.thesis = thesis;
  }

  public String getProgress() {
      return progress;
  }

  public void setProgress(String progress) {
      this.progress = progress;
  }




}
