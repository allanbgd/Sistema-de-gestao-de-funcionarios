package com.wakandaacademy.sistemadegestaodefuncionarios.service;

import org.bson.types.ObjectId; // Para ObjectId

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wakandaacademy.sistemadegestaodefuncionarios.domain.Funcionario;
import com.wakandaacademy.sistemadegestaodefuncionarios.exception.FuncionarioNotFoundException;
import com.wakandaacademy.sistemadegestaodefuncionarios.repository.FuncionarioRepository;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    // Método para adicionar um novo funcionário
    public Funcionario adicionarFuncionario(Funcionario funcionario) {
        // Valida o funcionário antes de salvar
        validarFuncionario(funcionario);
        return repository.save(funcionario);
    }

    // Método para buscar um funcionário
 public Funcionario buscarFuncionario(String id) {
    // Convert ObjectId to String if necessary
    ObjectId objectId = new ObjectId(id);
    return repository.findById(objectId.toHexString()).orElseThrow(() -> new FuncionarioNotFoundException(id));
}


    // Método para listar todos os funcionários
    public List<Funcionario> listarFuncionarios() {
        return repository.findAll();
    }

    // Método para atualizar um funcionário
    public Funcionario atualizarFuncionario(String id, Funcionario funcionarioAtualizado) {
        // Valida o funcionário atualizado
        validarFuncionario(funcionarioAtualizado);
        
        Funcionario funcionarioExistente = buscarFuncionario(id);
        funcionarioExistente.setNome(funcionarioAtualizado.getNome());
        funcionarioExistente.setDesignacao(funcionarioAtualizado.getDesignacao());
        funcionarioExistente.setSalario(funcionarioAtualizado.getSalario());
        funcionarioExistente.setNumero(funcionarioAtualizado.getNumero());
        funcionarioExistente.setEndereco(funcionarioAtualizado.getEndereco());
        
        return repository.save(funcionarioExistente);
    }

    // Método para excluir um funcionário
    public void excluirFuncionario(String id) {
        Funcionario funcionarioExistente = buscarFuncionario(id);
        repository.delete(funcionarioExistente);
    }

    // Método de validação do funcionário
    public void validarFuncionario(Funcionario funcionario) {
        if (funcionario.getNome() == null || funcionario.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do funcionário é obrigatório.");
        }
        if (funcionario.getSalario() <= 0) {
            throw new IllegalArgumentException("O salário deve ser maior que zero.");
        }
        if (String.valueOf(funcionario.getNumero()).length() != 9) {
            throw new IllegalArgumentException("O número de telefone deve ter 9 dígitos.");
        }else if(String.valueOf(funcionario.getNumero()).isEmpty()){
            throw new IllegalArgumentException("O número de telefone é obrigatório.");
        }
        if (String.valueOf(funcionario.getNumero()).length() != 9) {
            throw new IllegalArgumentException("O Endereço do funcionário é obrigatório.");
    }
}
}
    

