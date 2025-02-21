package br.insper.produto.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto createProduto(Produto produto) {
        Produto produto1 = produtoRepository.findByNome(produto.getNome());

        if (produto1 != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        else {
            return produtoRepository.save(produto);
        }
    }

    public Produto findProduto(String id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Produto reduceProduto(String id, Integer qtd) {
        Produto produto = findProduto(id);

        produto.setQtd(produto.getQtd()-qtd);

        return produtoRepository.save(produto);
    }

    public List<Produto> getProdutos() {
        return produtoRepository.findAll();
    }
}
