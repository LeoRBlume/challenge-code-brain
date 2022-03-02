package br.com.codeBrian.application.use_case;

import br.com.codeBrian.interfaces.dto.ProdutosVendidosDTO;
import br.com.codeBrian.interfaces.dto.VendedoresPorMaisVendasDTO;
import br.com.codeBrian.interfaces.dto.VendedoresValorVendidoDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class RelatorioUseCase {
    public Response ItensMaisVendidos(List<Object[]> resultList) {

        List<ProdutosVendidosDTO> produtosDTOS = new ArrayList<>();

        try {
            for (Object[] obj : resultList) {
                produtosDTOS.add(ProdutosVendidosDTO.transformarObjeto(obj));
            }
            return Response.ok(produtosDTOS).status(200).build();
        } catch (Exception e) {
            return Response.ok("Algum erro inesperado aconteceu.").status(400).build();
        }
    }

    public Response vendedoresValorVendido(List<Object[]> resultList) {

        List<VendedoresValorVendidoDTO> vendidoDTOS = new ArrayList<>();

        try {
            for (Object[] obj : resultList) {
                vendidoDTOS.add(VendedoresValorVendidoDTO.transformarObjeto(obj));
            }
            return Response.ok(vendidoDTOS).status(200).build();
        } catch (Exception e) {
            return Response.ok("Algum erro inesperado aconteceu.").status(400).build();
        }

    }

    public Response vendedoresPorVenda(List<Object[]> resultList) {
        List<VendedoresPorMaisVendasDTO> vendasTOS = new ArrayList<>();

        try {
            for (Object[] obj : resultList) {
                vendasTOS.add(VendedoresPorMaisVendasDTO.transformarObjeto(obj));
            }
            return Response.ok(vendasTOS).status(200).build();
        } catch (Exception e) {
            return Response.ok("Algum erro inesperado aconteceu.").status(400).build();
        }
    }
}
