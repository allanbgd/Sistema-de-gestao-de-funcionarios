package com.wakandaacademy.sistemadegestaodefuncionarios.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
@Document(collection = "funcionarios")
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter

public class Funcionario {
    @Id
    private String id;// pode-se usar @MongoId(TargetType = FieldType.String )
    private String nome;
    private String designacao;
    private double salario;
    private int numero;
    private String endereco;

 
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
