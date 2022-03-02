package br.com.codeBrian.interfaces.form;

import java.util.List;

public class VendaForm {

    private Long matricula;
    private List<String> nomeProdutos;

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public List<String> getNomeProdutos() {
        return nomeProdutos;
    }

    public void setNomeProdutos(List<String> nomeProdutos) {
        this.nomeProdutos = nomeProdutos;
    }
}
