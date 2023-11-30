package com.example.cadastromusica.Controller;

import com.example.cadastromusica.HelloApplication;
import com.example.cadastromusica.Model.Album;
import com.example.cadastromusica.Model.Musica;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MusicaController {

    @FXML
    private TextField nomeTextField;
    @FXML
    private TextField generoTextField;
    @FXML
    private TextField duracaoTextField;

    @FXML
    private TableView<Musica> musicaTableView;

    @FXML
    private TableColumn<Musica, String> nomeColumn;

    @FXML
    private TableColumn<Musica, String> generoColumn;

    @FXML
    private TableColumn<Musica, Float> duracaoColumn;

    @FXML
    private VBox musicaVbox;

    private void initialize(){
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        generoColumn.setCellValueFactory(new PropertyValueFactory<>("genero"));
        duracaoColumn.setCellValueFactory(new PropertyValueFactory<>("duracao"));

        musicaTableView.setItems(FXCollections.observableArrayList(Musica.listarMusica()));
    }

    @FXML
    void backHome(ActionEvent event)  throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) musicaVbox.getScene().getWindow();
        stage.setTitle("Cadastro musical");
        stage.setScene(scene);
        stage.show();
    }

    public void cadastrar() {
        String nome = nomeTextField.getText();
        String genero = generoTextField.getText();
        Float duracao = Float.valueOf(duracaoTextField.getText());

        Musica.cadastrar(nome, genero, duracao);


        nomeTextField.clear();
        generoTextField.clear();
        duracaoTextField.clear();

        musicaTableView.setItems(FXCollections.observableArrayList(Musica.listarMusica()));
    }

    public void cadastrarAlbum(ActionEvent actionEvent){
    }

}
