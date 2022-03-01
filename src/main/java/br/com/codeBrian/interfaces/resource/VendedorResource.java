package br.com.codeBrian.interfaces.resource;

import br.com.codeBrian.domain.model.Vendedor;
import br.com.codeBrian.infraestructure.repository.VendedorRepository;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("vendedor")
public class VendedorResource {

    @Inject
    VendedorRepository repository;

    @GET
    public List<Vendedor> listar() {
        return repository.listAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{matricula}")
    public Response getOne(@PathParam Long matricula) {
        Optional<Vendedor> vendedor = repository.findByMatricula(matricula);

        if (vendedor.isPresent()) {
            return Response.ok(vendedor.get()).status(200).build();
        } else return Response.ok().status(404).build();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserir(Vendedor vendedor) {
        if (repository.findByMatricula(vendedor.getMatricula()).isPresent()) {
            return Response.ok().status(422).build();
        }
        repository.persist(vendedor);
        return Response.ok(vendedor).status(201).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response atualizar(Vendedor vendedor) {
        Optional<Vendedor> vendedorBanco = repository.findByMatricula(vendedor.getMatricula());
        if (vendedorBanco.isPresent()) {
            vendedorBanco.get().setNome(vendedor.getNome());
            return Response.ok(vendedorBanco.get()).status(200).build();
        } else return Response.ok().status(404).build();
    }

    @DELETE
    @Path("/{matricula}")
    @Transactional
    public Response delete(@PathParam Long matricula) {
        Optional<Vendedor> vendedorBD = repository.findByMatricula(matricula);
        if (vendedorBD.isPresent()){
            repository.delete(vendedorBD.get());
            return Response.ok().status(200).build();
        }
        else{
            return Response.ok().status(404).build();
        }
    }
}
