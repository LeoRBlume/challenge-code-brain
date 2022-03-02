package br.com.codeBrian.interfaces.resource;

import br.com.codeBrian.infraestructure.repository.RelatorioRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/relatorios")
public class RelatorioResource {

    @Inject
    RelatorioRepository repository;

    @GET
    @Path("/itensMaisVendidos")
    public Response relatorioItensMaisVendidos() {
        return repository.ItensMaisVendidos();
    }

    @GET
    @Path("/vendedoresValorVendido")
    public Response relatorioVendedoresPorValorVendido(){
        return repository.vendedoresValorVendido();
    }

    @GET
    @Path("/vendedoresPorVenda")
    public Response relatorioVendedoresVenda(){
        return repository.vendedoresVenda();
    }

}
