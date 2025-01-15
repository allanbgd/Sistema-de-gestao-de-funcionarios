package com.wakandaacademy.sistemadegestaodefuncionarios;

public class FuncionarioNotFoundException extends RuntimeException {
    public FuncionarioNotFoundException(String id) {
        super("Funcionário com ID " + id + " não encontrado.");
    }
}
