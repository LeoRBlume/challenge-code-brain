package br.com.codeBrian.application.use_case;

import br.com.codeBrian.domain.model.Produto;
import br.com.codeBrian.infraestructure.repository.ProdutoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.ws.rs.core.Response;
import java.util.Optional;

@ApplicationScoped
public class ProdutoUseCase {

    @Inject
    ProdutoRepository repository;

    public Response deletarProduto(Long idProduto) {
        try {
            Optional<Produto> produtoOptional = repository.findByIdOptional(idProduto);
            if (produtoOptional.isPresent()) {
                repository.delete(produtoOptional.get());
                return Response.ok(produtoOptional.get()).status(200).build();
            }
            return Response.ok("Não a nenhum produto com esse Id").status(404).build();
        } catch (PersistenceException e) {
            return Response.ok("Impossivel deletar um vendedor vinculado a uma venda!!").status(400).build();

        }
    }

    public Response atualizarPedido(Produto produto)  {
        Optional<Produto> produtoOptional = repository.findByIdOptional(produto.getId());
        if (produtoOptional.isPresent()) {
            produtoOptional.get().setNome(produto.getNome());
            produtoOptional.get().setPreco(produto.getPreco());
            return Response.ok().status(200).build();
        } else return Response.ok().status(404).build();
    }

    public Response cadastrarProduto(Produto produto) {
        Optional<Produto> produtoOptional = repository.findByNome(produto.getNome());

        if (produtoOptional.isPresent()) return Response.ok("Ja existe um produto com esse nome!!").status(422).build();

        repository.persist(produto);

        return Response.ok(repository.findByNome(produto.getNome())).status(200).build();

    }
}
