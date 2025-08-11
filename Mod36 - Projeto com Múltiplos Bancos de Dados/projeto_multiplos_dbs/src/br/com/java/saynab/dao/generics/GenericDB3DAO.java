package br.com.java.saynab.dao.generics;

import br.com.java.saynab.domain.Persistente;

import java.io.Serializable;

public abstract class GenericDB3DAO<T extends Persistente, E extends Serializable> extends GenericDAO<T,E> {

    public GenericDB3DAO(Class<T> persistenteClass) {
        super(persistenteClass,"Mysql1");
    }
}
