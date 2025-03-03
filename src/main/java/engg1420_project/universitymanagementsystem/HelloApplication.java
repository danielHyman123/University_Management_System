package engg1420_project.universitymanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Group root = new Group();
        stage = new Stage();
        Scene test = new Scene(root, 600, 600, Color.LIGHTGRAY);
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("University Management System!");

        //Text
        Text text = new Text();
        text.setText("University Management System");
        text.setFont(Font.font("Verdana", 50));
        text.setX(50);
        text.setY(50);
        text.setFill(Color.BLACK);

        Line line = new Line();
        line.setStartX(100);
        line.setStartY(100);
        line.setEndX(100);
        line.setEndY(500);

        root.getChildren().add(text);
        root.getChildren().add(line);

        stage.setScene(test);
//        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}