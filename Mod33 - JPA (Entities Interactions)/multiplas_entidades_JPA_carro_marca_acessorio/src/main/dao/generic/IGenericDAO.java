package main.dao.generic;

public interface IGenericDAO<T> {

    public T cadastrar(T entidade);

    public T buscarPorId(Class<T> entidade, Long id);
}
