package com.example.cadastromusica.Controller;

import com.example.cadastromusica.HelloApplication;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
public class startController {

    public Button albumbutton;

    public Button musicabutton;

    public Button artistabutton;
    @FXML
    private VBox homeVbox;

    @FXML
    void goToAlbum(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("cadastrarAlbum.fxml"));
        Scene scene = new Scene(loader.load(),600,420);
        Stage stage = (Stage) homeVbox.getScene().getWindow();
        stage.setTitle("Albums");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void goToMusica(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("cadastrarMusica.fxml"));
        Scene scene = new Scene(loader.load(),600,420);
        Stage stage = (Stage) homeVbox.getScene().getWindow();
        stage.setTitle("Músicas");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void goToArtista(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("cadastrarArtista.fxml"));
        Scene scene = new Scene(loader.load(),600,420);
        Stage stage = (Stage) homeVbox.getScene().getWindow();
        stage.setTitle("Artistas");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void initialize(){
        addHoverTransition(albumbutton);
        addHoverTransition(musicabutton);
        addHoverTransition(artistabutton);
    }

    private void addHoverTransition(Button button) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), button);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);

        button.setOnMouseEntered(event -> scaleTransition.playFromStart());
        button.setOnMouseExited(event -> scaleTransition.playFromStart());
    }

}
