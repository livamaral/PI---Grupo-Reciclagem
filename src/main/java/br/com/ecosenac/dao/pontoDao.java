package br.com.ecosenac.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.ecosenac.model.CadastroPonto;

public class pontoDao {
  private static final String JDBC_URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    private static final String USUARIO = "seu_usuario";
    private static final String SENHA = "sua_senha";

    public void cadastrarPonto(CadastroPonto ponto) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USUARIO, SENHA)) {
            String sql = "INSERT INTO PONTOS_DE_COLETA (NOME, ENDERECO, NUMERO, CEP) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, ponto.getNome());
                statement.setString(2, ponto.getEndereco());
                statement.setInt(3, ponto.getNumero());
                statement.setString(4, ponto.getCep());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar ponto de coleta: " + e.getMessage());
        }
    }
    public List<CadastroPonto> listarPontos() {
        List<CadastroPonto> pontos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USUARIO, SENHA)) {
            String sql = "SELECT * FROM PONTOS_DE_COLETA";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    CadastroPonto ponto = new CadastroPonto();
                    ponto.setNome(resultSet.getString("NOME"));
                    ponto.setEndereco(resultSet.getString("ENDERECO"));
                    ponto.setNumero(resultSet.getInt("NUMERO"));
                    ponto.setCep(resultSet.getString("CEP"));

                    pontos.add(ponto);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar pontos de coleta: " + e.getMessage());
        }

        return pontos;
    }
}
