package br.com.codeBrian.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vendedor {

    private String nome;

    @Id
    private Long matricula;

    public Vendedor() {
    }

    public Vendedor(String nome, Long matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "nome='" + nome + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}
