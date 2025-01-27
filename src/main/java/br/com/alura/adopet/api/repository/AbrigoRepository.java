package br.com.alura.adopet.api.repository;

import br.com.alura.adopet.api.model.Abrigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AbrigoRepository extends JpaRepository<Abrigo, Long> {

    boolean existsByNomeOrTelefoneOrEmail(String nome, String telefone, String email);

    Optional<Abrigo> findByNome(String nome);
}
