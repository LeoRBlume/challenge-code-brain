package br.com.codeBrian.interfaces.dto;

import java.math.BigInteger;

public class ProdutosVendidosDTO {


    private String nome;

    private BigInteger quantidadeVendida;

    public ProdutosVendidosDTO(String nome, BigInteger quantidadeVendida) {
        this.nome = nome;
        this.quantidadeVendida = quantidadeVendida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigInteger getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(BigInteger quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public static ProdutosVendidosDTO transformarObjeto(Object[] obj){
        return new ProdutosVendidosDTO((String)obj[0], (BigInteger) obj[1]);
    }

    @Override
    public String toString() {
        return "ProdutosVendidosDTO{" +
                ", nome='" + nome + '\'' +
                ", quantidadeVendida=" + quantidadeVendida +
                '}';
    }
}
