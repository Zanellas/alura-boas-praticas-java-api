package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.dto.DadosDetalhadosPetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<DadosDetalhadosPetDto> buscarPetsDisponiveis() {
        return petRepository.findAllByAdotadoFalse()
                .stream()
                .map(DadosDetalhadosPetDto::new)
                .toList();
    }

    public void cadastrarPet(Abrigo abrigo, CadastroPetDto dto) {
        petRepository.save(new Pet(abrigo, dto));
    }
}
