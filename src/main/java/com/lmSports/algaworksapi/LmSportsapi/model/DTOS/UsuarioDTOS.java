package com.lmSports.algaworksapi.LmSportsapi.model.DTOS;

import com.lmSports.algaworksapi.LmSportsapi.model.Permissao;
import com.lmSports.algaworksapi.LmSportsapi.model.Usuario;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public class UsuarioDTOS {

    public static volatile SingularAttribute<Usuario, String> senha;
    public static volatile ListAttribute<Usuario, Permissao> permissoes;
    public static volatile SingularAttribute<Usuario, Long> codigo;
    public static volatile SingularAttribute<Usuario, String> nome;
    public static volatile SingularAttribute<Usuario, String> email;

}