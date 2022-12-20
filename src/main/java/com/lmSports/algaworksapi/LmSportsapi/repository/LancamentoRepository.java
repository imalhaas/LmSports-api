package com.lmSports.algaworksapi.LmSportsapi.repository;

import com.lmSports.algaworksapi.LmSportsapi.model.Lancamento;

import com.lmSports.algaworksapi.LmSportsapi.repository.LANCAMENTO.LancamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {
}
