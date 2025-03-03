package br.com.saynab.domain;

import br.com.saynab.anotacao.ColunaTabela;
import br.com.saynab.anotacao.Tabela;

import java.math.BigDecimal;
import java.util.function.DoubleBinaryOperator;

@Tabela(nome = "TB_PRODUTO_QUANTIDADE")
public class ProdutoQuantidade implements Persistente{

    @ColunaTabela(dbName = "id",setJavaName = "setId")
    private Long id;

    private Produto produto;

    @ColunaTabela(dbName = "quantidade",setJavaName = "setQuantidade")
    private Integer quantidade;

    @ColunaTabela(dbName = "valor_total",setJavaName = "setValorTotal")
    private BigDecimal valorTotal;

    public ProdutoQuantidade() {
        this.quantidade = 0;
        this.valorTotal = BigDecimal.ZERO;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void adicionar(Integer quantidade){
        this.quantidade += quantidade;
        BigDecimal novoValor = produto.getValor().multiply(BigDecimal.valueOf(quantidade));
        BigDecimal novoTotal = valorTotal.add(novoValor);
        this.valorTotal = novoTotal;
    }


    public void remover(Integer quantidade){
        this.quantidade -= quantidade;
        BigDecimal novoValor = produto.getValor().multiply(BigDecimal.valueOf(quantidade));
        this.valorTotal = this.valorTotal.subtract(novoValor);
    }
}
