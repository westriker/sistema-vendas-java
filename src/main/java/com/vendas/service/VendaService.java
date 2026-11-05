package com.vendas.service;

import com.vendas.model.Produto;
import com.vendas.repository.ProdutoRepository;

public class VendaService {

    private final ProdutoRepository produtoRepository;

    public VendaService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public double calcularTotal(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        return produto.getPreco() * quantidade;
    }

    public void realizarVenda(Long produtoId, int quantidade) {
        Produto produto = produtoRepository.buscarPorId(produtoId)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado."));

        produto.removerEstoque(quantidade);
        produtoRepository.atualizar(produto);
    }
}