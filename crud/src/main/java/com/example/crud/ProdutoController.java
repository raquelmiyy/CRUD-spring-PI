package com.example.crud;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>();

    @GetMapping
    public List<Produto> listar() {
        return produtos;
    }

    @PostMapping
    public Produto cadastrar(@RequestBody Produto produtoNovo) {
        produtos.add(produtoNovo);
        return produtoNovo;
    }

    @PutMapping("/{indice}")
    public Produto atualizar(
            @PathVariable int indice,
            @RequestBody Produto produtoAtualizado) {
        if (indice >= 0 && indice < produtos.size()) {
            produtos.set(indice, produtoAtualizado);
            return produtoAtualizado;
        }
        return null;
    }

    @GetMapping("/estoque/{qtdEstoque}")
    public List<Produto> buscarPorEstoque(
            @PathVariable int qtdEstoque) {
        return produtos
                .stream().
                filter(produtodaVez -> produtodaVez.getQtdEstoque() >= qtdEstoque)
                .toList();
    }
}

