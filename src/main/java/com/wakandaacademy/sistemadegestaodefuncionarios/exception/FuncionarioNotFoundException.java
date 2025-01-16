package com.wakandaacademy.sistemadegestaodefuncionarios.exception;

public class FuncionarioNotFoundException extends RuntimeException {
    public FuncionarioNotFoundException(String id) {
        super("Funcionário com ID " + id + " não encontrado.");
    }
}
