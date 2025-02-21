package br.insper.produto.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getProdutos() {
        return produtoService.getProdutos();
    }

    @GetMapping("/{idProduto}")
    public Produto findProduto(@PathVariable String idProduto) { return produtoService.findProduto(idProduto); }

    @PostMapping
    public Produto postProduto(@RequestBody Produto produto) { return produtoService.createProduto(produto); }

    @PutMapping("/{idProduto")
    public Produto reduceProduto(@PathVariable String idProduto, @RequestBody Integer qtd) { return produtoService.reduceProduto(idProduto, qtd); }
}
