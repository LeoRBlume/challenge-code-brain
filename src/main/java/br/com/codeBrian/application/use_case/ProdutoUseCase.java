package br.com.codeBrian.application.use_case;

import br.com.codeBrian.domain.model.Produto;
import br.com.codeBrian.domain.model.Venda;
import br.com.codeBrian.infraestructure.repository.ProdutoRepository;
import br.com.codeBrian.infraestructure.repository.VendaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProdutoUseCase {

    @Inject
    ProdutoRepository repository;

    @Inject
    VendaRepository vendaRepository;

    public Response deletarProduto(Long idProduto) {
        try {
            Optional<Produto> produtoOptional = repository.findByIdOptional(idProduto);
            if (produtoOptional.isPresent()) {
                if (possivelDeletarProduto(idProduto)) {
                    return Response.ok(produtoOptional.get()).status(200).build();
                }
                return Response.ok("Impossivel deletar um vendedor vinculado a uma venda!!").status(400).build();
            }
            return Response.ok("Não a nenhum produto com esse Id").status(404).build();
        } catch (Exception e) {
            return Response.ok("Algum erro inesperado aconteceu!!").status(400).build();
        }
    }

    public Response atualizarPedido(Produto produto) {
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

    private boolean possivelDeletarProduto(Long idProduto) {

        List<Venda> vendas = vendaRepository.listAll();

        for (Venda v : vendas) {
            List<Produto> produtos = v.getProdutos();
            for (Produto p : produtos) {
                if (p.getId() == idProduto) return false;
            }
        }
        return true;
    }

}
