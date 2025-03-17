package engg1420group2.universitymanagementsystem.studentmanagement;

import java.util.ArrayList;
import java.util.HashMap;

public class sharedDatabase {

    private static String selectedName;

    public static String getSelectedName() {
        return selectedName;
    }

    public static void setSelectedName(String selectedName) {
        sharedDatabase.selectedName = selectedName;
    }

    static Student kyle = new Student("Kyle Egan", "default123", "kegan@example.edu", "123 Main St", "555-5555", "Undergraduate", "Fall 2025", "Research", "50%");
    static Student dan = new Student("Daniel Hyman", "default123", "danH@example.edu", "123 Main St", "555-5555", "Undergraduate", "Fall 2025", "Research", "50%");
    static Student mat = new Student("Mateo Doe", "default123", "email@example.edu", "123 Main St", "555-5555", "Undergraduate", "Fall 2025", "Research", "50%");
    static Student ant = new Student("Anthony John", "default123", "email@example.edu", "123 Main St", "555-5555", "Undergraduate", "Fall 2025", "Research", "50%");
    static Student ach = new Student("Achebe LastName", "default123", "Alast@example.edu", "123 Main St", "555-5555", "Undergraduate", "Fall 2025", "Research", "50%");

    public static HashMap<String, Student> studentHashMap = new HashMap<>();

    public static ArrayList<Student> studentArrayList = new ArrayList<>() {{
        add(kyle);
        add(dan);
        add(mat);
        add(ant);
        add(ach);
    }};

    public static ArrayList<String> stdNameList = new ArrayList<>() {{
        add("Kyle Egan");
        add("Daniel Hyman");
        add("Mateo Doe");
        add("Anthony John");
        add("Achebe LastName");
    }};
    

    public sharedDatabase() {
        for (int i = 0; i < studentArrayList.size(); i++) {
            studentHashMap.put(stdNameList.get(i), studentArrayList.get(i));
        }

    }

    public static Student getStudent(String key) {
        return studentHashMap.get(key);
    }

    public static void removeStudent(String key) {
        studentHashMap.remove(key);
        stdNameList.remove(key);
        studentArrayList.remove(key);
    }

    public static void addStudent(String key, Student student) {
        studentHashMap.put(key, student);
        stdNameList.add(key);
        studentArrayList.add(student);
    }



}
