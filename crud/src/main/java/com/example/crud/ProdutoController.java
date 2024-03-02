package com.example.crud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto novoProduto) {
        produtos.add(novoProduto);
        return ResponseEntity.status(201).body(novoProduto);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getProdutos() {
        if (produtos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(produtos);
    }


    @GetMapping("/{indice}")
    public ResponseEntity<Produto> get(@PathVariable int indice) {
        if (indice >=0 && indice < produtos.size()) {
            return ResponseEntity.status(200)
                    .body(produtos.get(indice));
        }
        return ResponseEntity.status(404).build();
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

