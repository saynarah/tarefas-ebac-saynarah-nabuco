package br.com.java.saynab.dao;

import br.com.java.saynab.dao.generics.IGenericDAO;
import br.com.java.saynab.domain.Cliente;
import br.com.java.saynab.domain.Persistente;

public interface IClienteDAO<T extends Persistente> extends IGenericDAO<T,Long>  {
}
