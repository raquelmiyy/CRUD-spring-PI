package com.example.crud.Controller;

import com.example.crud.Model.Fornecedor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

public class FonecedorController {
    private List<Fornecedor> fornecedores = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Fornecedor>> getFornecedores() {
        if (fornecedores.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(fornecedores);
    }

    @DeleteMapping("/{indice}")
    public Fornecedor delete(@PathVariable int indice){
        return fornecedores.remove(indice);
    }

}
