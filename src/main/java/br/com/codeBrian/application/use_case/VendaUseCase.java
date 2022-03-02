package br.com.codeBrian.application.use_case;

import br.com.codeBrian.domain.model.Produto;
import br.com.codeBrian.domain.model.Venda;
import br.com.codeBrian.domain.model.Vendedor;
import br.com.codeBrian.infraestructure.repository.ProdutoRepository;
import br.com.codeBrian.infraestructure.repository.VendaRepository;
import br.com.codeBrian.infraestructure.repository.VendedorRepository;
import br.com.codeBrian.interfaces.form.VendaForm;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class VendaUseCase {

    @Inject
    VendaRepository vendaRepository;

    @Inject
    VendedorRepository vendedorRepository;

    @Inject
    ProdutoRepository produtoRepository;

    public Response realizarVenda(VendaForm vendaForm) {

        Venda venda = new Venda();

        Optional<Vendedor> vendedorOptional = vendedorRepository.findByMatricula(vendaForm.getMatricula());

        if (vendedorOptional.isPresent()) {
            venda.setVendedor(vendedorOptional.get());
        } else return Response.ok("Não foi possivel encontrar um vendedor com essa matricula!!").status(404).build();

        List<Produto> produtos = new ArrayList<>();

        double valorTotal = 0.0;

        for (String nomeProduto : vendaForm.getNomeProdutos()) {
            Optional<Produto> produtoOptional = produtoRepository.findByNome(nomeProduto);
            if (produtoOptional.isPresent()) {
                produtos.add(produtoOptional.get());
                valorTotal += produtoOptional.get().getPreco();
            }
        }

        if (produtos.isEmpty())
            return Response.ok("Não é possivel cadastrar uma venda sem produtos").status(404).build();

        venda.setProdutos(produtos);

        venda.setValorTotal(valorTotal);

        System.out.println(venda.getVendedor());

        for (Produto p : venda.getProdutos()) System.out.println(p);

        System.out.println(venda.getValorTotal());

        vendaRepository.persist(venda);

        return Response.ok(venda).status(200).build();
    }
}
