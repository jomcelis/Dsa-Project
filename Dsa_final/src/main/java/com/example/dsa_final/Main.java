package com.example.dsa_final;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage stg;

    public Main() {
    }

    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), 800.0, 600.0);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(this.getClass().getResource("/com/example/dsa_final/" + fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch(new String[0]);
    }
}

