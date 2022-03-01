package br.com.codeBrian.interfaces.resource;

import br.com.codeBrian.application.use_case.VendedorUseCase;
import br.com.codeBrian.domain.model.Vendedor;
import br.com.codeBrian.infraestructure.repository.VendedorRepository;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("vendedor")
public class VendedorResource {

    @Inject
    VendedorRepository repository;

    @Inject
    VendedorUseCase useCase;

    @GET
    public Response listarVendedores() {
        return Response.ok(repository.listAll()).status(200).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{idVendedor}")
    public Response obterVendedor(@PathParam Long idVendedor) {
        return useCase.obterVendedor(idVendedor);

    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirVendedor(Vendedor vendedor) {
        return useCase.inserirVendedor(vendedor);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response atualizarVendedor(Vendedor vendedor) {
       return useCase.atualizarVendedor(vendedor);
    }

    @DELETE
    @Path("/{idVendedor}")
    @Transactional
    public Response deletarVendedor(@PathParam Long idVendedor) {
        return useCase.deletarVendedor(idVendedor);
    }
}
