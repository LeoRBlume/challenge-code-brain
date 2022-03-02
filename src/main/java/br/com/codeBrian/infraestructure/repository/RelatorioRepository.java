package br.com.codeBrian.infraestructure.repository;

import br.com.codeBrian.application.use_case.RelatorioUseCase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class RelatorioRepository {

    @Inject
    EntityManager em;

    @Inject
    RelatorioUseCase useCase;

    private String queryItensMaisVendidos = "SELECT p.nome, COUNT(*) from Produto as p " +
            "join Venda_Produto as v on p.id = v.produtos_id " +
            "group by p.nome " +
            "order by COUNT(*) DESC;";

    private String queryVendedoresValorVendido = "select vd.id, vd.nome, SUM(v.valorTotal) from Venda as v " +
            "join Vendedor as vd on v.vendedor_id = vd.id " +
            "group by vd.id " +
            "order by SUM(v.valorTotal) DESC;";

    private String queryVendedorMaisVendas = "SELECT vd.id, vd.nome, COUNT(*) from Vendedor as vd " +
            "join Venda as v on vd.id = v.vendedor_id " +
            "group by vd.id " +
            "order by COUNT(*) DESC;";


    public Response ItensMaisVendidos() {

        Query query = this.em.createNativeQuery(queryItensMaisVendidos);

        return useCase.ItensMaisVendidos(query.getResultList());

    }

    public Response vendedoresValorVendido() {

        Query query = this.em.createNativeQuery(queryVendedoresValorVendido);

        return useCase.vendedoresValorVendido(query.getResultList());
    }

    public Response vendedoresVenda() {

        Query query = this.em.createNativeQuery(queryVendedorMaisVendas);

        return useCase.vendedoresPorVenda(query.getResultList());

    }
}
