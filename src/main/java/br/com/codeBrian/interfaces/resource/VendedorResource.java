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
    @Path("/{matricula}")
    public Response obterVendedor(@PathParam Long matricula) {
        return useCase.obterVendedor(matricula);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirVendedor(Vendedor vendedor) {
        try {
            return useCase.inserirVendedor(vendedor);
        } catch (Exception e) {
            return Response.ok("Algum erro inesperado aconteceu!!").status(400).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response atualizarVendedor(Vendedor vendedor) {
        try {
            return useCase.atualizarVendedor(vendedor);
        } catch (IllegalArgumentException e) {
            return Response.ok("Necessario passar o id para atualizar!!").status(400).build();
        } catch (Exception e) {
            return Response.ok("Algum erro inesperado aconteceu!!").status(400).build();
        }
    }

    @DELETE
    @Path("/{idVendedor}")
    @Transactional
    public Response deletarVendedor(@PathParam Long idVendedor) {
        try {
            return useCase.deletarVendedor(idVendedor);
        } catch (Exception e) {
            return Response.ok("Algum erro inesperado aconteceu!!").status(400).build();
        }
    }
}
