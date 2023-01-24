package com.paulohenrique.gerenciar_pessoas.service;

import com.paulohenrique.gerenciar_pessoas.exeception.ExeceptionPersonalizada;
import com.paulohenrique.gerenciar_pessoas.model.Pessoa;
import com.paulohenrique.gerenciar_pessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa buscarPessoaPorId(Long id){
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        pessoaOptional.orElseThrow(()
        -> new ExeceptionPersonalizada("Pessoa não cadastrada", HttpStatus.BAD_REQUEST));
        return pessoaOptional.get();
    }
}
