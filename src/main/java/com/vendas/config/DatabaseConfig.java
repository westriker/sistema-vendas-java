package com.vendas.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConfig {
    private static final String URL = "jdbc:h2:./data/vendasdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASS = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASS);
    }
    public static void initDatabase() {
        String sqlProduto = """
            CREATE TABLE IF NOT EXISTS produto (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                nome VARCHAR(255) NOT NULL,
                preco DOUBLE NOT NULL,
                quantidade INT NOT NULL
            );
        """;
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlProduto);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inicializar a base de dados H2", e);
        }
    }
}