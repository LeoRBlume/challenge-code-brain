package br.com.codeBrian.interfaces.resource;

import br.com.codeBrian.application.use_case.ProdutoUseCase;
import br.com.codeBrian.domain.model.Produto;
import br.com.codeBrian.infraestructure.repository.ProdutoRepository;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/produto")
public class ProdutoResource {

    @Inject
    ProdutoRepository repository;

    @Inject
    ProdutoUseCase useCase;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPedidos() {
        try {
            return Response.ok(repository.listAll()).status(200).build();
        } catch (Exception e) {
            return Response.ok("Algum erro inesperado aconteceu!!").status(400).build();
        }
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirProduto(Produto produto) {
        try {
            return useCase.cadastrarProduto(produto);
        } catch (Exception e) {
            return Response.ok("Algum erro inesperado aconteceu!!").status(400).build();
        }
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarPedido(Produto produto) {
        try {
            return useCase.atualizarPedido(produto);

        } catch (Exception e) {
            return Response.ok("Algum erro inesperado aconteceu!!").status(400).build();
        }
    }

    @DELETE
    @Path("/{idProduto}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarProduto(@PathParam Long idProduto) {
        try {
            return useCase.deletarProduto(idProduto);
        } catch (Exception e) {
            return Response.ok("Algum erro inesperado aconteceu!!").status(400).build();
        }
    }
}
