package com.wakandaacademy.sistemadegestaodefuncionarios;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "funcionarios")
public class Funcionario {
    @Id
    private String id;
    private String nome;
    private String designacao;
    private double salario;
    private int numero;
    private String endereco;

    // Construtor
    public Funcionario( String nome, String designacao, double salario, int numero, String endereco) {
        this.nome = nome;
        this.designacao = designacao;
        this.salario = salario;
        this.numero = numero;
        this.endereco = endereco;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Equals e HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Double.compare(that.salario, salario) == 0 &&
               numero == that.numero &&
               Objects.equals(id, that.id) &&
               Objects.equals(nome, that.nome) &&
               Objects.equals(designacao, that.designacao) &&
               Objects.equals(endereco, that.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, designacao, salario, numero, endereco);
    }
}
