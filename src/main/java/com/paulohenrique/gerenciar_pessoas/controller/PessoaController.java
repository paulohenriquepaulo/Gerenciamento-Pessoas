package com.paulohenrique.gerenciar_pessoas.controller;

import com.paulohenrique.gerenciar_pessoas.dto.PessoaRequestDTO;
import com.paulohenrique.gerenciar_pessoas.dto.PessoaResponseDTO;
import com.paulohenrique.gerenciar_pessoas.mapper.PessoaMapper;
import com.paulohenrique.gerenciar_pessoas.model.Pessoa;
import com.paulohenrique.gerenciar_pessoas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaMapper pessoaMapper;

    @PostMapping
    public ResponseEntity<PessoaResponseDTO> salvar(@RequestBody @Valid
                                                    PessoaRequestDTO dto) {
        Pessoa novaPessoa = pessoaService.salvar(pessoaMapper.toPessoa(dto));
        PessoaResponseDTO responseDTO = pessoaMapper.toPessoaReponseDTO(novaPessoa);
        return ResponseEntity.ok(responseDTO);
    }
}
