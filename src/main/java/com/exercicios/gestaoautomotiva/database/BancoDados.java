package com.exercicios.gestaoautomotiva.database;

import com.exercicios.gestaoautomotiva.models.Carro;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class BancoDados {
    private List<Carro> carros = new ArrayList<>();

    public List<Carro> addCarro(Carro carro) {
        carro.setId(UUID.randomUUID().toString());
        carros.add(carro);
        return carros;
    }

    public List<Carro> list() {
        return carros;
    }

    public List<Carro> deleteCarro(String carroId) {
        List<Carro> novaListaCarros = new ArrayList<>(carros);

        for (Carro carro: carros) {
            if (carro.getId().equals(carroId)) {
                novaListaCarros.remove(carro);
            }
        }

        carros = novaListaCarros;

        return carros;
    }

    public List<Carro> updateCarro(String carroId, Carro carroAtualizado) {
        for (Carro carro: carros) {
            if (carro.getId().equals(carroId)) {
                carro.setNome(carroAtualizado.getNome());
                carro.setCor(carroAtualizado.getCor());
            }
        }

        return carros;
    }
}
