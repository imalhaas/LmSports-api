package com.lmSports.algaworksapi.LmSportsapi.model.DTOS;

import com.lmSports.algaworksapi.LmSportsapi.model.Endereco;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Endereco.class)
public abstract class EnderecoDTOS {



        public static volatile SingularAttribute<Endereco, String> cidade;
        public static volatile SingularAttribute<Endereco, String> estado;
        public static volatile SingularAttribute<Endereco, String> complemento;
        public static volatile SingularAttribute<Endereco, String> numero;
        public static volatile SingularAttribute<Endereco, String> logradouro;
        public static volatile SingularAttribute<Endereco, String> bairro;
        public static volatile SingularAttribute<Endereco, String> cep;

    }

