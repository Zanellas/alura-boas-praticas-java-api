package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.TipoPet;

public record DadosDetalhadosPet(
        Long id,
        TipoPet tipo,
        String nome,
        String raca,
        Integer idade
) {
    public DadosDetalhadosPet(Pet pet){
        this(pet.getId(), pet.getTipo(), pet.getNome(), pet.getRaca(), pet.getIdade());
    }
}
