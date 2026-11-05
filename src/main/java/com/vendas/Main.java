package com.vendas;

import com.vendas.config.DatabaseConfig;
import com.vendas.model.Produto;
import com.vendas.repository.ProdutoRepository;
import com.vendas.service.VendaService;

public class Main {
    public static void main(String[] args) {
        // Inicializa as tabelas do H2
        DatabaseConfig.initDatabase();

        ProdutoRepository repository = new ProdutoRepository();
        VendaService vendaService = new VendaService(repository);

        // Cadastra um novo produto
        Produto novoProduto = new Produto(null, "Teclado Mecanico", 150.0, 10);
        novoProduto = repository.salvar(novoProduto);

        System.out.println("Produto cadastrado com ID: " + novoProduto.getId());

        // Realiza uma venda reduzindo o estoque na base de dados H2
        vendaService.realizarVenda(novoProduto.getId(), 2);

        // Busca novamente para confirmar a persistência
        Produto produtoSalvo = repository.buscarPorId(novoProduto.getId()).orElseThrow();
        System.out.println("Estoque atualizado no H2: " + produtoSalvo.getQuantidadeEmEstoque());
    }
}