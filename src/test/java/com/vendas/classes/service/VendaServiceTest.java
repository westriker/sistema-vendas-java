package com.vendas.service;

import com.vendas.model.Produto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VendaServiceTest {

    @Test
    void deveCalcularTotalDaVendaCorretamente() {
        Produto produto = new Produto(1L, "Caderno", 20.0, 10);
        VendaService service = new VendaService();

        double total = service.calcularTotal(produto, 3);

        assertEquals(60.0, total);
    }

    @Test
    void deveLancarExcecaoSeStockInsuficiente() {
        Produto produto = new Produto(2L, "Caneta", 2.0, 5);
        VendaService service = new VendaService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.realizarVenda(produto, 10); // Apenas o valor direto, sem "quantidade:"
        });
    }
}