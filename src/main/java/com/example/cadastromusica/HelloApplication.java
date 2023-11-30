package com.example.cadastromusica;

import com.example.cadastromusica.Controller.startController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        startController startController = fxmlLoader.getController();
        Scene scene = new Scene(fxmlLoader.load(), 310, 563);
        stage.setTitle("Cadastro musical");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}