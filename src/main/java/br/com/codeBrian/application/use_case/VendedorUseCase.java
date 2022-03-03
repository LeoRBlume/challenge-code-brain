package br.com.codeBrian.application.use_case;

import br.com.codeBrian.domain.model.Venda;
import br.com.codeBrian.domain.model.Vendedor;
import br.com.codeBrian.infraestructure.repository.VendaRepository;
import br.com.codeBrian.infraestructure.repository.VendedorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@ApplicationScoped
public class VendedorUseCase {

    @Inject
    VendedorRepository repository;

    @Inject
    VendaRepository vendaRepository;

    public Response deletarVendedor(Long idVendedor) {
        try {
            Optional<Vendedor> vendedorOptional = repository.findByIdOptional(idVendedor);
            if (vendedorOptional.isPresent()) {
                if(possivelDeletarVendedor(idVendedor)) return Response.ok(vendedorOptional.get()).status(200).build();
                return Response.ok("Impossivel deletar um vendedor vinculado a uma venda!!").status(400).build();
            } else {
                return Response.ok().status(404).build();
            }
        }
        catch (Exception e){
            return Response.ok("Algum erro inesperado aconteceu!!").status(400).build();
        }
    }

    private boolean possivelDeletarVendedor(Long idVendedor) {
        List<Venda> vendaList = vendaRepository.listAll();

        for (Venda v : vendaList){
            if(v.getVendedor().getId() == idVendedor) return false;
        }
        return true;
    }

    public Response inserirVendedor(Vendedor vendedor) {
        if (vendedor.getMatricula() == null) {
            return Response.ok("Necessario passar a matricula para cadastrar um vendedor").status(400).build();
        }
        if (repository.findByMatricula(vendedor.getMatricula()).isPresent()) {
            return Response.ok("Ja existe um vendedor com essa matricula").status(422).build();
        }
        repository.persist(vendedor);
        return Response.ok(repository.findByMatricula(vendedor.getMatricula())).status(201).build();
    }

    public Response obterVendedor(Long matricula) {
        Optional<Vendedor> vendedor = repository.findByMatricula(matricula);

        if (vendedor.isPresent()) {
            return Response.ok(vendedor.get()).status(200).build();
        } else return Response.ok().status(404).build();
    }

    public Response atualizarVendedor(Vendedor vendedor) {
        Optional<Vendedor> vendedorOptional = repository.findByIdOptional(vendedor.getId());
        if (vendedorOptional.isPresent()) {
            vendedorOptional.get().setNome(vendedor.getNome());
            vendedorOptional.get().setMatricula(vendedor.getMatricula());
            return Response.ok().status(200).build();
        } else return Response.ok().status(404).build();
    }
}
