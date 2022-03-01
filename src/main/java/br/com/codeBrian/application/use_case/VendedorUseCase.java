package br.com.codeBrian.application.use_case;

import br.com.codeBrian.domain.model.Vendedor;
import br.com.codeBrian.infraestructure.repository.VendedorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Optional;

@ApplicationScoped
public class VendedorUseCase {

    @Inject
    VendedorRepository repository;

    public Response deletarVendedor(Long idVendedor) {
        Optional<Vendedor> vendedorOptional = repository.findByIdOptional(idVendedor);
        if (vendedorOptional.isPresent()) {
            repository.delete(vendedorOptional.get());
            return Response.ok(vendedorOptional.get()).status(200).build();
        } else {
            return Response.ok().status(404).build();
        }
    }

    public Response inserirVendedor(Vendedor vendedor) {
        if (repository.findByMatricula(vendedor.getMatricula()).isPresent()) {
            return Response.ok("Ja existe um vendedor com essa matricula").status(422).build();
        }
        repository.persist(vendedor);
        return Response.ok(vendedor).status(201).build();
    }

    public Response obterVendedor(Long idVendedor) {
        Optional<Vendedor> vendedor = repository.findByIdOptional(idVendedor);

        if (vendedor.isPresent()) {
            return Response.ok(vendedor.get()).status(200).build();
        } else return Response.ok().status(404).build();
    }

    public Response atualizarVendedor(Vendedor vendedor) {
        Optional<Vendedor> vendedorOptional = repository.findByIdOptional(vendedor.getId());
        if (vendedorOptional.isPresent()) {
            vendedorOptional.get().setNome(vendedor.getNome());
            vendedorOptional.get().setMatricula(vendedor.getMatricula());
            return Response.ok(vendedorOptional.get()).status(200).build();
        } else return Response.ok().status(404).build();
    }
}
