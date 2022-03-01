package br.com.codeBrian.interfaces.resource;

import br.com.codeBrian.application.use_case.VendedorUseCase;
import br.com.codeBrian.domain.model.Venda;
import br.com.codeBrian.infraestructure.repository.VendaRepository;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/venda")
public class VendaResource {

    @Inject
    VendedorUseCase useCase;

    @Inject
    VendaRepository repository;


}
