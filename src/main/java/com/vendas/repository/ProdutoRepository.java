package com.vendas.repository;

import com.vendas.config.DatabaseConfig;
import com.vendas.model.Produto;

import java.sql.*;
import java.util.Optional;

public class ProdutoRepository {

    public Produto salvar(Produto produto) {
        String sql = "INSERT INTO produto (nome, preco, quantidade) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidadeEmEstoque());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    produto.setId(rs.getLong(1));
                }
            }
            return produto;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar produto", e);
        }
    }

    public Optional<Produto> buscarPorId(Long id) {
        String sql = "SELECT * FROM produto WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Produto produto = new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade")
                    );
                    return Optional.of(produto);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produto", e);
        }
        return Optional.empty();
    }

    public void atualizar(Produto produto) {
        String sql = "UPDATE produto SET quantidade = ? WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, produto.getQuantidadeEmEstoque());
            stmt.setLong(2, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto", e);
        }
    }
}