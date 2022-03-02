package br.com.codeBrian.interfaces.dto;

import java.math.BigInteger;

public class VendedoresPorMaisVendasDTO {

    private BigInteger idVendedor;

    private String nome;

    private BigInteger quantidadeVendida;

    public VendedoresPorMaisVendasDTO(BigInteger idVendedor, String nome, BigInteger quantidadeVendida) {
        this.idVendedor = idVendedor;
        this.nome = nome;
        this.quantidadeVendida = quantidadeVendida;
    }

    public static VendedoresPorMaisVendasDTO transformarObjeto(Object[] obj) {
        return new VendedoresPorMaisVendasDTO((BigInteger) obj[0], (String) obj[1], (BigInteger)obj[2]);
    }

    public BigInteger getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(BigInteger idVendedor) {
        this.idVendedor = idVendedor;
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

    @Override
    public String toString() {
        return "VendedoresPorMaisVendasDTO{" +
                "idVendedor=" + idVendedor +
                ", nome='" + nome + '\'' +
                ", quantidadeVendida=" + quantidadeVendida +
                '}';
    }
}
