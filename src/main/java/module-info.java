module engg1420group2.universitymanagementsystem.studentmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens engg1420group2.universitymanagementsystem.studentmanagement to javafx.fxml;
    exports engg1420group2.universitymanagementsystem.studentmanagement;
}