package com.wakandaacademy.sistemadegestaodefuncionarios.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.wakandaacademy.sistemadegestaodefuncionarios.domain.Funcionario;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {
}

