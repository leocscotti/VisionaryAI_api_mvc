package br.com.fiap.visionaryAI.repository;

import br.com.fiap.visionaryAI.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
