package engg1420group2.universitymanagementsystem.studentmanagement;

import java.util.HashMap;

/*
This file has a sample hashmap that other classes can access
Just so  I don't need multiple sample hashmaps set up
 */

public class sharedModel {
    private static String selectedName;
    //private HashMap<String, Student> studentHashMap = new HashMap<String, Student>();
    private HashMap<String, Student> studentHashMap;



    public static String getSelectedName() {
        return selectedName;
    }

    public static void setSelectedName(String selectedName) {
        sharedModel.selectedName = selectedName;
    }

    public sharedModel() {
        //Creates and populates the hashmap with sample student files
        studentHashMap = new HashMap<>();



    }

    public Student getValueForKey(String key) {
        return studentHashMap.get(key);
    }









}
