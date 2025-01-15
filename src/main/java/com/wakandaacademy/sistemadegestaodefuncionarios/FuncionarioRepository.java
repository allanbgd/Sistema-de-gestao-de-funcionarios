package com.wakandaacademy.sistemadegestaodefuncionarios;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FuncionarioRepository extends MongoRepository<Funcionario, ObjectId> {
}

