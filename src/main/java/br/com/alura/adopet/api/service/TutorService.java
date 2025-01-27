package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.AtualizacaoTutorDto;
import br.com.alura.adopet.api.dto.CadastroTutorDto;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    public void cadastrar(@Valid CadastroTutorDto dto) {
        boolean jaCadastrado = tutorRepository.existsByTelefoneOrEmail(dto.telefone(), dto.email());
        if (jaCadastrado) {
            throw new ValidationException("Dados já cadastrados para outro tutor!");
        }
        tutorRepository.save(new Tutor(dto));
    }

    public void atualizar(@Valid AtualizacaoTutorDto dto) {
        Tutor turor = tutorRepository.getReferenceById(dto.id());
        turor.atualizarDados(dto);
    }
}
