package com.paulohenrique.gerenciar_pessoas.repository;

import com.paulohenrique.gerenciar_pessoas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
