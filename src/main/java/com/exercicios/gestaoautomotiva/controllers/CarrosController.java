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

    @GetMapping
    public List<Carro> listarCarro() {
        return bancoDados.list();
    }

    @PostMapping
    public List<Carro> criarCarro(@RequestBody Carro carro) {
        return bancoDados.addCarro(carro);
    }

    @DeleteMapping("/{carroId}")
    public List<Carro> deletarCarro(@PathVariable String carroId) {
        return bancoDados.deleteCarro(carroId);
    }

    @PutMapping("/{carroId}")
    public List<Carro> atualizarCarro(@PathVariable String carroId, @RequestBody Carro carro) {
        return bancoDados.updateCarro(carroId, carro);
    }
}
