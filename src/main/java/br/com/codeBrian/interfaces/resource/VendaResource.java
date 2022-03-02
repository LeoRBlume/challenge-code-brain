package br.com.codeBrian.interfaces.resource;

import br.com.codeBrian.application.use_case.VendaUseCase;
import br.com.codeBrian.application.use_case.VendedorUseCase;
import br.com.codeBrian.domain.model.Venda;
import br.com.codeBrian.infraestructure.repository.VendaRepository;
import br.com.codeBrian.interfaces.form.VendaForm;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/venda")
public class VendaResource {

    @Inject
    VendaUseCase useCase;

    @Inject
    VendaRepository repository;

    @POST
    @Transactional
    public Response inserir(VendaForm venda){
        return useCase.realizarVenda(venda);
    }
}
