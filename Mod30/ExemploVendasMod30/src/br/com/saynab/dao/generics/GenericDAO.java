package br.com.saynab.dao.generics;

import br.com.saynab.anotacao.ColunaTabela;
import br.com.saynab.anotacao.Tabela;
import br.com.saynab.dao.ConnectionFactory;
import br.com.saynab.domain.Venda;
import br.com.saynab.exception.*;
import br.com.saynab.fabrica.SingletonMap;
import br.com.saynab.anotacao.TipoChave;
import br.com.saynab.domain.Persistente;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class GenericDAO<T extends Persistente,E extends Serializable> implements IGenericDAO<T,E> {

    private SingletonMap singletonMap;

    public abstract Class<T> getTipoClasse();

    public abstract void atualiarDados(T entity, T entityCadastrado);

    public GenericDAO() {
        this.singletonMap = SingletonMap.getInstance();
    }

    protected abstract String getQueryInsercao();

    protected abstract void AdicionarParametrosInsert(PreparedStatement stm,T entity) throws SQLException;

    protected abstract void AdicionarParametrosSelect(PreparedStatement stm,E valor) throws SQLException;

    protected abstract String getQueryExclusao();

    protected abstract void adicionarParametrosQueryExclusao(PreparedStatement stm, E valor) throws SQLException;

    protected abstract String getQueryAtualizacao();

    protected abstract void adicionarParametrosQueryAtualizacao(PreparedStatement stm, T entity) throws SQLException;


    public Long getChave(T entity) throws TipoChaveNaoEncontradaException {
        Field[] fields = entity.getClass().getDeclaredFields();
        Long returnValue = null;
        for (Field field : fields) {
            if (field.isAnnotationPresent(TipoChave.class)) {
                TipoChave tipoChave = field.getAnnotation(TipoChave.class);
                String nomeMetodo = tipoChave.value();
                try {
                    Method method = entity.getClass().getMethod(nomeMetodo);
                    returnValue = (Long) method.invoke(entity);
                    return returnValue;
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    //Criar exception de negócio TipoChaveNaoEncontradaException
                    e.printStackTrace();
                    throw new TipoChaveNaoEncontradaException("Chave principal do objeto " + entity.getClass() + " não encontrada", e);
                }
            }
        }
        if (returnValue == null) {
            String msg = "Chave principal do objeto " + entity.getClass() + " não encontrada";
            System.out.println("**** ERRO ****" + msg);
            throw new TipoChaveNaoEncontradaException(msg);
        }
        return null;
    }

    @Override
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException, SQLException {

        Connection conexao = null;
        PreparedStatement stm = null;

        try{
            conexao = getConnection();
            String sql = getQueryInsercao();
            stm = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            AdicionarParametrosInsert(stm,entity);
            int rowsAffected = stm.executeUpdate();

            if(rowsAffected >0){
                try (ResultSet rs = stm.getGeneratedKeys()){
                    if(rs.next()){
                        Persistente per = (Persistente) entity;
                        per.setId(rs.getLong(1));
                    }
                }
                return true;
            }
        }
        catch(SQLException e){
            throw new DAOException("Erro ao cadastrar objeto ",e);

        } finally {
            closeConnection(conexao,stm,null);

        }
        return false;
    }

    protected void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) throws SQLException {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();

            }
        } catch (SQLException e1) {
            e1.printStackTrace();

        }
    }

    @Override
    public void excluir(E valor) throws DAOException, SQLException {
        Connection conexao = null;
        PreparedStatement stm = null;
        try{
            conexao = getConnection();
            stm = conexao.prepareStatement(getQueryExclusao());
            adicionarParametrosQueryExclusao(stm,valor);
            int rowsAffected = stm.executeUpdate();
        } catch (SQLException e){
            throw new DAOException("Erro excluindo objeto ",e);
        } finally {
            closeConnection(conexao,stm,null);
        }

    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException, SQLException {
        Connection conexao = null;
        PreparedStatement stm = null;
        try{
            conexao = getConnection();
            stm = conexao.prepareStatement(getQueryAtualizacao());
            adicionarParametrosQueryAtualizacao(stm,entity);
            int rowsAffected = stm.executeUpdate();
        } catch (SQLException e){
            throw new DAOException("Erro alterando objeto ",e);
        } finally {
            closeConnection(conexao,stm,null);
        }

    }

    @Override
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException, SQLException {
            Connection conexao = null;
            PreparedStatement stm = null;
            ResultSet rs = null;
            validarMaisDeUmRegistro(valor);

        try {
            conexao = getConnection();
            stm = conexao.prepareStatement("SELECT * FROM " + getTableName() + " WHERE " + getNomeCampoChave(getTipoClasse()) + " = ?");
            AdicionarParametrosSelect(stm,valor);
            rs = stm.executeQuery();

            if(rs.next()){
                T entity = getTipoClasse().getConstructor(null).newInstance(null);
                Field[] fields = entity.getClass().getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(ColunaTabela.class)) {
                        ColunaTabela coluna = field.getAnnotation(ColunaTabela.class);
                        String dbName = coluna.dbName();
                        String javaSetName = coluna.setJavaName();
                        Class<?> classField = field.getType();
                        try {
                            Method method = entity.getClass().getMethod(javaSetName,classField);
                            SetValueByType(entity,method,classField,rs,dbName);
                        } catch(NoSuchMethodException |IllegalAccessException | InvocationTargetException e){
                            throw new DAOException("ERRO CONSULTANDO OBJETO ",e);
                        } catch(TipoElementoNaoConhecidoException e){
                            throw new DAOException("ERRO CONSULTANDO OBJETO ",e);
                            
                        }
                        
                    }
                }
                return entity;

            }

        } catch(SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new DAOException("ERRO CONSULTANDO OBJETO ", e);
        }

        finally {
            closeConnection(conexao,stm,rs);
        }

        return null;
    }

    private Long validarMaisDeUmRegistro(E valor) throws TableException, SQLException {
        Connection conexao = getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        Long count = null;
        try{
            stm = conexao.prepareStatement("SELECT count(*) FROM " + getTableName() + " WHERE " + getNomeCampoChave(getTipoClasse()) + " = ?");
            AdicionarParametrosSelect(stm,valor);
            rs = stm.executeQuery();
            if(rs.next()) {
                count = rs.getLong(1);
                if(count > 1){
                    throw new MaisDeUmRegistroException("ENCONTRADO MAIS DE UM REGISTRO COM A MESMA CHAVE");
                }
            }
            return count;
        } catch(SQLException | MaisDeUmRegistroException e){
            e.printStackTrace();
        } finally {
            closeConnection(conexao,stm,rs);
        }
        return count;
    }



    private void SetValueByType(T entity, Method method, Class<?> classField, ResultSet rs, String dbName) throws SQLException, InvocationTargetException, IllegalAccessException {

        if(classField.equals(Integer.class)){
            Integer val = rs.getInt(dbName);
            method.invoke(entity,val);
        } else if(classField.equals(Long.class)){
            Long val = rs.getLong(dbName);
            method.invoke(entity,val);
        } else if(classField.equals(Double.class)){
            Double val = rs.getDouble(dbName);
            method.invoke(entity,val);
        } else if(classField.equals(Short.class)){
            Short val = rs.getShort(dbName);
            method.invoke(entity,val);
        } else if(classField.equals(BigDecimal.class)){
            BigDecimal val = rs.getBigDecimal(dbName);
            method.invoke(entity,val);
        } else if(classField.equals(String.class)){
            String val = rs.getString(dbName);
            method.invoke(entity,val);
        } else {
            throw new TipoElementoNaoConhecidoException("TIPO DE CLASSE NÃO CONHECIDO: " + classField);
        }
    }


    private String getNomeCampoChave(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(TipoChave.class) && field.isAnnotationPresent(ColunaTabela.class)) {
                ColunaTabela coluna = field.getAnnotation(ColunaTabela.class);
                return coluna.dbName();
            }
        }
        return null;
    }

    private String getTableName() throws TableException {
        if(getTipoClasse().isAnnotationPresent(Tabela.class)){
            Tabela table = getTipoClasse().getAnnotation(Tabela.class);
            return table.nome();
        }else {
            throw new TableException("TABELA DO TIPO" + getTipoClasse().getName() + " NÃO FOI ENCONTRADA");
        }
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException, SQLException, TableException {
        Connection conexao = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<T> list = new ArrayList();

        try {
            conexao = getConnection();
            stm = conexao.prepareStatement("SELECT * FROM " + getTableName());
            rs = stm.executeQuery();

            while(rs.next()){
                T entity = getTipoClasse().getConstructor(null).newInstance(null);
                Field[] fields = entity.getClass().getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(ColunaTabela.class)) {
                        ColunaTabela coluna = field.getAnnotation(ColunaTabela.class);
                        String dbName = coluna.dbName();
                        String javaSetName = coluna.setJavaName();
                        Class<?> classField = field.getType();
                        try {
                            Method method = entity.getClass().getMethod(javaSetName,classField);
                            SetValueByType(entity,method,classField,rs,dbName);
                        } catch(NoSuchMethodException |IllegalAccessException | InvocationTargetException e){
                            throw new DAOException("ERRO CONSULTANDO OBJETO ",e);
                        } catch(TipoElementoNaoConhecidoException e){
                            throw new DAOException("ERRO CONSULTANDO OBJETO ",e);

                        }

                    }
                }
                list.add(entity);

            }

        } catch(SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new DAOException("ERRO CONSULTANDO OBJETO ", e);
        }

        finally {
            closeConnection(conexao,stm,rs);
        }

        return list;
    }

    protected Connection getConnection() throws SQLException {
     return ConnectionFactory.getConnection();
    }



}