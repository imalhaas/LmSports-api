package com.lmSports.algaworksapi.LmSportsapi.repository.LANCAMENTO;

import com.lmSports.algaworksapi.LmSportsapi.model.Lancamento;
import com.lmSports.algaworksapi.LmSportsapi.repository.Filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LancamentoRepositoryQuery {

    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
}
