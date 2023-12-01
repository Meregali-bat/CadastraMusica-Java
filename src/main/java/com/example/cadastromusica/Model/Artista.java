package com.example.cadastromusica.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Artista {

    public Artista(String nome, String genero, int idade){
        this.nome = nome;
        this.genero = genero;
        this .idade = idade;
    }

    private String nome;
    private String genero;
    private int idade;

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    private static final String URL = "jdbc:mysql://localhost:3306/javafx";
    private static final String USUARIO ="root";
    private static final String SENHA = "";

    public static void cadastrar(String nome, String genero, int idade){
        try(Connection connection = DriverManager.getConnection(URL,USUARIO,SENHA)){
            String sql = "INSERT INTO artista (nome,genero,idade)   VALUE (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, genero);
                preparedStatement.setInt(3, idade);
                preparedStatement.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Artista> listarArtista(){
        List<Artista> Artistas = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "SELECT * FROM artista";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String nome = resultSet.getString("nome");
                        String genero = resultSet.getString("genero");
                        int idade = resultSet.getInt("idade");
                        Artista artista = new Artista(nome, genero, idade);
                        Artistas.add(artista);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Artistas;
    }

    public static void excluir(Artista artista) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "DELETE FROM artista WHERE nome = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, artista.getNome());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
