package com.vendas.service;

import com.vendas.model.Produto;

public class VendaService {

    public double calcularTotal(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        return produto.getPreco() * quantidade;
    }

    public void realizarVenda(Produto produto, int quantidade) {
        produto.removerEstoque(quantidade);
    }
}