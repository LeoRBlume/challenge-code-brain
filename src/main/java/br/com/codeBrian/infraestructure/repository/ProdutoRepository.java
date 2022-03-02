package br.com.codeBrian.infraestructure.repository;

import br.com.codeBrian.domain.model.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto> {


    public Optional<Produto> findByNome(String nomeProduto) {
        return find("nome", nomeProduto).firstResultOptional();
    }

    public void listarProdutosMaisVendidos() {
    }
}
