package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.TipoPet;

public record DadosDetalhadosPetDto(
        Long id,
        TipoPet tipo,
        String nome,
        String raca,
        Integer idade
) {
    public DadosDetalhadosPetDto(Pet pet){
        this(pet.getId(), pet.getTipo(), pet.getNome(), pet.getRaca(), pet.getIdade());
    }
}
