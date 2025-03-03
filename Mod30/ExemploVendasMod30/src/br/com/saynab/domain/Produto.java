package br.com.saynab.domain;

import br.com.saynab.anotacao.ColunaTabela;
import br.com.saynab.anotacao.Tabela;
import br.com.saynab.anotacao.TipoChave;

import java.math.BigDecimal;

@Tabela(nome = "TB_PRODUTO")
public class Produto implements Persistente{

    @TipoChave("getCodigo")
    @ColunaTabela(dbName = "codigo",setJavaName = "setCodigo")
    private String codigo;

    @ColunaTabela(dbName = "nome",setJavaName = "setNome")
    private String nome;

    @ColunaTabela(dbName = "descricao",setJavaName = "setDescricao")
    private String descricao;

    @ColunaTabela(dbName = "id",setJavaName = "setId")
    private Long id;

    @ColunaTabela(dbName = "valor",setJavaName = "setValor")
    private BigDecimal valor;

    @ColunaTabela(dbName = "categoria",setJavaName = "setCategoria")
    private String categoria;


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                '}';
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}