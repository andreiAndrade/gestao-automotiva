package com.exercicios.gestaoautomotiva.controllers;

import com.exercicios.gestaoautomotiva.database.BancoDados;
import com.exercicios.gestaoautomotiva.models.Carro;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarrosController {

    private final BancoDados bancoDados;

    public CarrosController(BancoDados bancoDados) {
        this.bancoDados = bancoDados;
    }

    /**
    * Listar carros
    */
    @GetMapping
    public List<Carro> list() {
        return bancoDados.list();
    }

    /**
    * Criar carro
    */
    @PostMapping
    public List<Carro> create(@RequestBody Carro carro) {
        return bancoDados.addCarro(carro);
    }

    /**
     * Deletar carro
     */
    @DeleteMapping("/{carroId}")
    public List<Carro> delete(@PathVariable String carroId) {
        return bancoDados.deleteCarro(carroId);
    }

    /**
     * Atualizar carro
     */
    @PutMapping("/{carroId}")
    public List<Carro> update(@PathVariable String carroId, @RequestBody Carro carro) {
        return bancoDados.updateCarro(carroId, carro);
    }
}
