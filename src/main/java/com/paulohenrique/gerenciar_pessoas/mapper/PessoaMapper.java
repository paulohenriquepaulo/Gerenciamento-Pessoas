package com.paulohenrique.gerenciar_pessoas.mapper;


import com.paulohenrique.gerenciar_pessoas.dto.PessoaEditarRequestDTO;
import com.paulohenrique.gerenciar_pessoas.dto.PessoaRequestDTO;
import com.paulohenrique.gerenciar_pessoas.dto.PessoaResponseDTO;
import com.paulohenrique.gerenciar_pessoas.model.Pessoa;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    Pessoa toPessoa(PessoaRequestDTO pessoaRequestDTO);
    Pessoa toPessoa(PessoaEditarRequestDTO pessoaEditarRequestDTO);

    PessoaResponseDTO toPessoaReponseDTO(Pessoa pessoa);

   List<PessoaResponseDTO> toPessoaReponseDTO(List<Pessoa> pessoa);
}
