package com.example.cadastromusica.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Album {

    public Album(String nome, String genero, String dataLancamento){
        this.nome = nome;
        this.genero = genero;
        this.dataLancamento = dataLancamento;
    }

    private String nome;
    private String genero;
    private String dataLancamento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    private static final String URL = "jdbc:mysql://localhost:3306/javafx";
    private static final String USUARIO ="root";
    private static final String SENHA = "";

    public static void cadastrar(String nome, String genero, String dataLancamento){
        try(Connection connection = DriverManager.getConnection(URL,USUARIO,SENHA)){
            String sql = "INSERT INTO album (nome,genero,dataLancamento) VALUE (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, genero);
                preparedStatement.setString(3, dataLancamento);
                preparedStatement.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Album> listarAlbums(){
        List<Album> Albums = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "SELECT * FROM album";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String nome = resultSet.getString("nome");
                        String genero = resultSet.getString("genero");
                        String dataLancamento = resultSet.getString("dataLancamento");
                        Album album = new Album(nome, genero, dataLancamento);
                        Albums.add(album);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Albums;
    }

}