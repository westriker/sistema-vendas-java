package com.vendas.exception;

public class StockInsuficienteException extends RuntimeException {
    public StockInsuficienteException(String mensagem) {
        super(mensagem);
    }
}