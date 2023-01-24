package com.paulohenrique.gerenciar_pessoas.controller;

import com.paulohenrique.gerenciar_pessoas.dto.PessoaEditarRequestDTO;
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
import java.util.List;

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

    @GetMapping
    public ResponseEntity<PessoaResponseDTO> buscarPessoaPorId(@RequestParam
                                                    Long id) {
        Pessoa pessoa = pessoaService.buscarPessoaPorId(id);
        return ResponseEntity.ok(pessoaMapper.toPessoaReponseDTO(pessoa));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PessoaResponseDTO>> buscarPessoas() {
        List<Pessoa> pessoas = pessoaService.listarPessoas();
        return ResponseEntity.ok(pessoaMapper.toPessoaReponseDTO(pessoas));
    }

    @PatchMapping()
    public ResponseEntity<PessoaResponseDTO> buscarPessoas(@RequestBody PessoaEditarRequestDTO pessoaEditarRequestDTO) {
        Pessoa pessoa = pessoaService.editarPessoa(pessoaMapper.toPessoa(pessoaEditarRequestDTO));
        return ResponseEntity.ok(pessoaMapper.toPessoaReponseDTO(pessoa));
    }

}
