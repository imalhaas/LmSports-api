package com.lmSports.algaworksapi.LmSportsapi.service;

import com.lmSports.algaworksapi.LmSportsapi.model.Lancamento;
import com.lmSports.algaworksapi.LmSportsapi.model.Pessoa;
import com.lmSports.algaworksapi.LmSportsapi.repository.LancamentoRepository;
import com.lmSports.algaworksapi.LmSportsapi.repository.PessoaRepository;
import com.lmSports.algaworksapi.LmSportsapi.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento) {
        Pessoa pessoa = pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
        if (pessoa == null || pessoa.isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }
        return lancamentoRepository.save(lancamento);
    }
}