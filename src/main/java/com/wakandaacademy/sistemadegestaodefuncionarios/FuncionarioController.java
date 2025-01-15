package com.wakandaacademy.sistemadegestaodefuncionarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    // Adicionar um novo funcionário
    @PostMapping
    public Funcionario adicionarFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.adicionarFuncionario(funcionario);
    }

    // Obter todos os funcionários
    @GetMapping
    public List<Funcionario> listarFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }

    // Obter um funcionário específico pelo ID
    @GetMapping("/{id}")
    public Funcionario buscarFuncionario(@PathVariable String id) {
        return funcionarioService.buscarFuncionario(id);
    }

    // Atualizar os dados de um funcionário
    @PutMapping("/{id}")
    public Funcionario atualizarFuncionario(@PathVariable String id, @RequestBody Funcionario funcionarioAtualizado) {
        return funcionarioService.atualizarFuncionario(id, funcionarioAtualizado);
    }

    // Excluir um funcionário pelo ID
    @DeleteMapping("/{id}")
    public void excluirFuncionario(@PathVariable String id) {
        funcionarioService.excluirFuncionario(id);
    }
}
