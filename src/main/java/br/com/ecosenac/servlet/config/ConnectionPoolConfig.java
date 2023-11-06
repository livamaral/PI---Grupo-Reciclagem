package br.com.ecosenac.servlet.config;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolConfig {

    private static BasicDataSource dataSource;

    private ConnectionPoolConfig() {
        getDataSource();
    }

    private static BasicDataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/ecosenac"); // Remova o ponto e vírgula do final
            dataSource.setUsername(""); // Substitua pelo seu nome de usuário do MySQL
            dataSource.setPassword(""); // Substitua pela sua senha do MySQL
            dataSource.setMinIdle(5); // Número mínimo de conexões ociosas no pool
            dataSource.setMaxIdle(10); // Número máximo de conexões ociosas no pool
            dataSource.setMaxTotal(50); // Número máximo de conexões totais no pool

            System.out.println("New connection pool created with successful");
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
}
