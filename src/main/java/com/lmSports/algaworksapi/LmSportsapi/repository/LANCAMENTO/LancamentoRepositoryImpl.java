package com.lmSports.algaworksapi.LmSportsapi.repository.LANCAMENTO;

import com.lmSports.algaworksapi.LmSportsapi.model.DTOS.LancamentosDTOS;
import com.lmSports.algaworksapi.LmSportsapi.model.Lancamento;
import com.lmSports.algaworksapi.LmSportsapi.repository.Filter.LancamentoFilter;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class LancamentoRepositoryImpl implements LancamentoRepositoryQuery{

  @PersistenceContext
  private EntityManager manager;


    @Override
    public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Lancamento> criteria = builder.createQuery(Lancamento.class);
        Root<Lancamento> root = criteria.from(Lancamento.class);


        Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<Lancamento> query = manager.createQuery(criteria);


        return query.getResultList();
    }

    private Predicate[] criarRestricoes(LancamentoFilter lancamentoFilter, CriteriaBuilder builder, Root<Lancamento> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(lancamentoFilter.getDescricao())) {
         predicates.add(builder.like(
                 builder.lower(root.get(LancamentosDTOS.descricao)), "%" + lancamentoFilter.getDescricao().toLowerCase() + "%"));
        }
        if(lancamentoFilter.getDataVencimentoDe() != null){
            predicates.add(
                    builder.greaterThanOrEqualTo(root.get(LancamentosDTOS.dataVencimento), lancamentoFilter.getDataVencimentoDe()));
        }
        if (lancamentoFilter.getDataVencimentoAte() !=null){
           predicates.add(
                   builder.lessThanOrEqualTo(root.get(LancamentosDTOS.dataVencimento), lancamentoFilter.getDataVencimentoAte()));
        }


        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
