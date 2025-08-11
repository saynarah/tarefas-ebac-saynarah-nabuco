package br.com.java.saynab.dao.generics;

import br.com.java.saynab.domain.Persistente;
import java.io.Serializable;

public abstract class GenericDB1DAO<T extends Persistente, E extends Serializable> extends GenericDAO<T,E> {

    public GenericDB1DAO(Class<T> persistenteClass) {
        super(persistenteClass,"Postgres1");
    }
}
