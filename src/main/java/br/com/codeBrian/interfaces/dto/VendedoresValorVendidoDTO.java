package br.com.codeBrian.interfaces.dto;

import java.math.BigInteger;

public class VendedoresValorVendidoDTO {

    private BigInteger idVendedor;

    private String nome;

    private double valorVendido;

    public VendedoresValorVendidoDTO(BigInteger idVendedor, String nome, double valorVendido) {
        this.idVendedor = idVendedor;
        this.nome = nome;
        this.valorVendido = valorVendido;
    }


    public static VendedoresValorVendidoDTO transformarObjeto(Object[] obj) {
        return new VendedoresValorVendidoDTO((BigInteger)obj[0] , (String) obj[1], (double) obj[2]);
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

    public double getValorVendido() {
        return valorVendido;
    }

    public void setValorVendido(double valorVendido) {
        this.valorVendido = valorVendido;
    }

    @Override
    public String toString() {
        return "VendedoresValorVendidoDTO{" +
                "idVendedor=" + idVendedor +
                ", nome='" + nome + '\'' +
                ", valorVendido=" + valorVendido +
                '}';
    }
}
