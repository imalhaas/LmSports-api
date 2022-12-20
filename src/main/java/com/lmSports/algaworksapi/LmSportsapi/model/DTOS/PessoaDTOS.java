package com.lmSports.algaworksapi.LmSportsapi.model.DTOS;

import com.lmSports.algaworksapi.LmSportsapi.model.Endereco;
import com.lmSports.algaworksapi.LmSportsapi.model.Pessoa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pessoa.class)
public abstract class PessoaDTOS {

    public static volatile SingularAttribute<Pessoa, Long> codigo;
    public static volatile SingularAttribute<Pessoa, Boolean> ativo;
    public static volatile SingularAttribute<Pessoa, Endereco> endereco;
    public static volatile SingularAttribute<Pessoa, String> nome;

}