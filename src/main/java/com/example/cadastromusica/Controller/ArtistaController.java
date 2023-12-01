package com.example.cadastromusica.Controller;

import com.example.cadastromusica.HelloApplication;
import com.example.cadastromusica.Model.Album;
import com.example.cadastromusica.Model.Artista;
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
public class ArtistaController {

    @FXML
    private TextField nomeTextField;
    @FXML
    private TextField generoTextField;
    @FXML
    private TextField idadeTextField;

    @FXML
    private TableView<Artista> artistaTableView;

    @FXML
    private TableColumn<Artista, String> nomeColumn;

    @FXML
    private TableColumn<Artista, String> generoColumn;

    @FXML
    private TableColumn<Artista, String> idadeColumn;

    @FXML
    private VBox artistaVbox;

    private void initialize(){
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nomeColumn"));
        generoColumn.setCellValueFactory(new PropertyValueFactory<>("generoColumn"));
        idadeColumn.setCellValueFactory(new PropertyValueFactory<>("idadeColumn"));

        artistaTableView.setItems(FXCollections.observableArrayList(Artista.listarArtista()));
    }

    @FXML
    void backHome(ActionEvent event)  throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) artistaVbox.getScene().getWindow();
        stage.setTitle("Cadastro musical");
        stage.setScene(scene);
        stage.show();
    }

    public void cadastrar() {
        String nome = nomeTextField.getText();
        String genero = generoTextField.getText();
        int idade = Integer.parseInt(idadeTextField.getText());

        Artista.cadastrar(nome, genero, idade);


        nomeTextField.clear();
        generoTextField.clear();
        idadeTextField.clear();

        artistaTableView.setItems(FXCollections.observableArrayList(Artista.listarArtista()));
    }

    public void cadastrarArtista(ActionEvent actionEvent){
    }

    public void excluirArtista() {
        Artista artistaSelecionado = artistaTableView.getSelectionModel().getSelectedItem();

        if (artistaSelecionado != null) {
            Artista.excluir(artistaSelecionado);
            artistaTableView.setItems(FXCollections.observableArrayList(Artista.listarArtista()));
        } else {

        }
    }

}
