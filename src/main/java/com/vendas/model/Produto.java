package com.vendas.model;

public class Produto {
    private Long id;
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    // Construtor com 4 argumentos (incluindo o id)
    public Produto(Long id, String nome, double preco, int quantidadeEmEstoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public int getQuantidadeEmEstoque() { return quantidadeEmEstoque; }
    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) { this.quantidadeEmEstoque = quantidadeEmEstoque; }

    public void removerEstoque(int quantidade) {
        if (quantidade > quantidadeEmEstoque) {
            throw new IllegalArgumentException("Stock insuficiente.");
        }
        this.quantidadeEmEstoque -= quantidade;
    }
}