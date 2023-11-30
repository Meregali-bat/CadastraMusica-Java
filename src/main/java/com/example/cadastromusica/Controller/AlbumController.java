package com.example.cadastromusica.Controller;

import com.example.cadastromusica.HelloApplication;
import com.example.cadastromusica.Model.Album;
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
public class AlbumController {

    @FXML
    private TextField nomeTextField;
    @FXML
    private TextField generoTextField;
    @FXML
    private TextField anoTextField;

    @FXML
    private TableView<Album> albumTableView;

    @FXML
    private TableColumn<Album, String> nomeColumn;

    @FXML
    private TableColumn<Album, String> generoColumn;

    @FXML
    private TableColumn<Album, String> anoColumn;

    @FXML
    private VBox albumVbox;

    private void initialize(){
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        generoColumn.setCellValueFactory(new PropertyValueFactory<>("genero"));
        anoColumn.setCellValueFactory(new PropertyValueFactory<>("ano"));

        albumTableView.setItems(FXCollections.observableArrayList(Album.listarAlbums()));
    }

    @FXML
    void backHome(ActionEvent event)  throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) albumVbox.getScene().getWindow();
        stage.setTitle("Cadastro musical");
        stage.setScene(scene);
        stage.show();
    }

    public void cadastrar() {
        String nome = nomeTextField.getText();
        String genero = generoTextField.getText();
        String anoLancamento = anoTextField.getText();

        Album.cadastrar(nome, genero, anoLancamento);


        nomeTextField.clear();
        generoTextField.clear();
        anoTextField.clear();

        albumTableView.setItems(FXCollections.observableArrayList(Album.listarAlbums()));
    }

    public void cadastrarAlbum(ActionEvent actionEvent){
    }

}
