package br.com.codeBrian.infraestructure.repository;

import br.com.codeBrian.domain.model.Venda;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VendaRepository implements PanacheRepository<Venda> {
}
