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
        return Response.ok(repository.listAll()).status(200).build();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirProduto(Produto produto) {
        repository.persist(produto);
        return Response.ok(produto).status(200).build();
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarPedido(Produto produto) {
        return useCase.atualizarPedido(produto);
    }

    @DELETE
    @Path("/{idProduto}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarProduto(@PathParam Long idProduto) {
        return useCase.deletarProduto(idProduto);
    }
}
