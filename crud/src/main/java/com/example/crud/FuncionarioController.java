package com.example.crud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {

    private List<Funcionario> funcionarios = new ArrayList<>();

    @GetMapping
    public List<Funcionario> listar() {
        return funcionarios;
    }

    @PostMapping
    public Funcionario cadastrar(@RequestBody Funcionario funcionarioNovo) {
        funcionarios.add(funcionarioNovo);
        return funcionarioNovo;
    }
}
