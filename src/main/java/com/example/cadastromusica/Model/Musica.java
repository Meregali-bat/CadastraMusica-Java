package com.example.cadastromusica.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Musica {

    public Musica(String nome, String genero, float duracao){
        this.nome = nome;
        this.genero = genero;
        this.duracao = duracao;
    }

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

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }

    private String nome;
    private String genero;
    private float duracao;


    private static final String URL = "jdbc:mysql://localhost:3306/javafx";
    private static final String USUARIO ="root";
    private static final String SENHA = "";

    public static void cadastrar(String nome, String genero, float duracao){
        try(Connection connection = DriverManager.getConnection(URL,USUARIO,SENHA)){
            String sql = "INSERT INTO musica (nome,genero,duracao) VALUE (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, genero);
                preparedStatement.setFloat(3, duracao);
                preparedStatement.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Musica> listarMusica(){
        List<Musica> Musicas = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "SELECT * FROM musica";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String nome = resultSet.getString("nome");
                        String genero = resultSet.getString("genero");
                        float duracao = resultSet.getFloat("duracao");
                        Musica musica = new Musica(nome, genero, duracao);
                        Musicas.add(musica);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Musicas;
    }

}
