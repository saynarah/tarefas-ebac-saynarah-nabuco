package Dao.generic;

import java.util.Collection;

public interface IGeneric<T> {

    public Boolean cadastrar(T entity);

    public T excluir(Long valor);

    public T alterar(T entity);

    public T consultar(Long valor);

    public Collection<T> buscarTodos();

}
