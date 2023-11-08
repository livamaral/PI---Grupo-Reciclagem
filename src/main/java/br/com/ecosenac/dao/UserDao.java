package br.com.ecosenac.dao;

import br.com.ecosenac.servlet.ListClienteServlet;
import br.com.ecosenac.model.User;
import br.com.ecosenac.servlet.CreateEcoSenacServlet;
import br.com.ecosenac.servlet.config.ConnectionPoolConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao {

    public void createUser(User user) {
        String SQL = "INSERT INTO USUARIO (NOME,EMAIL,SENHA,TELEFONE) VALUES (?,?,?,?)";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, user.getNome());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getSenha());
            preparedStatement.setString(4, user.getTelefone());

            preparedStatement.execute();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }

    }

    public User exibirUser(String id) {
        String SQL = "SELECT * FROM USUARIO WHERE CLIENTEID = ?";
        User user = null;

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("Sucesso na conexão com o banco de dados");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String userNome = resultSet.getString("nome");
                String userEmail = resultSet.getString("email");
                String userSenha = resultSet.getString("senha");
                String userTelefone = resultSet.getString("telefone");
                String userId = resultSet.getString("Id");

                user = new User(userNome, userEmail, userSenha, userTelefone);
            }

            System.out.println("Sucesso na consulta ao cliente");

        } catch (SQLException e) {
            System.err.println("Erro na conexão com o banco de dados: " + e.getMessage());
        }
        if (user == null) {
            user = new User(); // Cliente vazio em caso de falha na consulta
        }

        return user;
    }

    public boolean verifyCredentials(User user) {

        String SQL = "SELECT * FROM USUARIO WHERE EMAIL = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, user.getEmail());

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            String id = resultSet.getString(1);

            System.out.println("success in select email");

            String senha = resultSet.getString("senha");

            if (senha.equals(user.getSenha())) {

                ListClienteServlet.setId(id);

                return true;

            }

            while (resultSet.next()) {

                if (senha.equals(user.getSenha())) {

                    return true;

                }

            }

            connection.close();

            return false;

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

            return false;

        }
    }

}
