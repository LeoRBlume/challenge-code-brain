package br.com.codeBrian.infraestructure.repository;

import br.com.codeBrian.domain.model.Vendedor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class VendedorRepository implements PanacheRepository<Vendedor> {

    public Optional<Vendedor> findByMatricula(Long matricula) {
       return find("matricula", matricula).firstResultOptional();
    }
}
