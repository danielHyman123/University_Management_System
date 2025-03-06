package engg1420group2.universitymanagementsystem.studentmanagement;

public class sharedModel {
    private static String selectedName;

    public static String getSelectedName() {
        return selectedName;
    }

    public static void setSelectedName(String selectedName) {
        sharedModel.selectedName = selectedName;
    }
}
