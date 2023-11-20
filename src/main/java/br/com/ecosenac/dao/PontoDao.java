package br.com.ecosenac.dao;

import br.com.ecosenac.model.Ponto;
import br.com.ecosenac.servlet.config.ConnectionPoolConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PontoDao {

    public void createPonto(Ponto ponto) {
        String SQL = "INSERT INTO PONTO (NOME,ENDERECO,CEP) VALUES (?,?,?)";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, ponto.getNome());
            preparedStatement.setString(2, ponto.getEndereco());
            preparedStatement.setString(3, ponto.getCep());

            preparedStatement.execute();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }
    }
    public Ponto exibirPonto(String id) {
        String SQL = "SELECT * FROM PONTO WHERE PONTOID = ?";
        Ponto ponto = null;

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("Sucesso na conexão com o banco de dados");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String pontoNome = resultSet.getString("nome");
                String pontoEndereco = resultSet.getString("Endereço");
                String pontoCep = resultSet.getString("CEP");
                String pontoId = resultSet.getString("Id");

                ponto = new Ponto(pontoNome, pontoEndereco, pontoCep);
            }

            System.out.println("Sucesso na consulta ao cliente");

        } catch (SQLException e) {
            System.err.println("Erro na conexão com o banco de dados: " + e.getMessage());
        }
        if (ponto == null) {
            ponto = new Ponto();
        }

        return ponto;
    }

}
