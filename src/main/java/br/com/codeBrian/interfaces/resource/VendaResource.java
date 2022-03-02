package br.com.codeBrian.interfaces.resource;

import br.com.codeBrian.application.use_case.VendaUseCase;
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

    @POST
    @Transactional
    public Response inserir(VendaForm venda) {
        try {
            return useCase.realizarVenda(venda);
        } catch (Exception e) {
            return Response.ok("Algum erro inesperado aconteceu!!").status(400).build();
        }
    }
}
