package br.com.saynab.domain;

import br.com.saynab.anotacao.ColunaTabela;
import br.com.saynab.anotacao.Tabela;
import br.com.saynab.anotacao.TipoChave;
import com.sun.source.util.SourcePositions;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Tabela(nome = "TB_VENDA")
public class Venda implements Persistente{

    public enum Status {
        INICIADA,CONCLUIDA,CANCELADA;

        public static Status getByName(String value) {
            for (Status status : Status.values()) {
                if (status.name().equals(value)){
                    return status;
                }
            }
            return null;
        }
    }

    @ColunaTabela(dbName = "id",setJavaName = "setId")
    private Long id;

    @TipoChave("getCodigo")
    @ColunaTabela(dbName = "codigo",setJavaName = "setCodigo")
    private String codigo;

    @ColunaTabela(dbName = "id_cliente_fk",setJavaName = "setIdClienteFk")
    private Cliente cliente;

    private Set<ProdutoQuantidade> produtos;

    @ColunaTabela(dbName = "valor_total",setJavaName = "setValorTotal")
    private BigDecimal valorTotal;

    @ColunaTabela(dbName = "data_venda",setJavaName = "setDataVenda")
    private Instant data_venda;

    @ColunaTabela(dbName = "status_venda",setJavaName = "setStatus")
    private Status status;

    //para ter uma venda, eu tenho um hashSet de produtos como construtor
    public Venda() {
        produtos = new HashSet<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<ProdutoQuantidade> getProdutos() {
        return produtos;
    }

    private void validarStatus() {
        if(Status.CONCLUIDA.equals(this.status)){
            throw new UnsupportedOperationException("Impossível alterar venda finalizada");
        }

    }

    public void adicionarProduto (Produto produto,Integer quantidade){
        validarStatus();
        Optional<ProdutoQuantidade> op =
                produtos.stream().filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();
        if(op.isPresent()){
            ProdutoQuantidade produtoQtd = op.get(); //.get() metodo nativo com o uso do Optional
            produtoQtd.adicionar(quantidade);
        } else {
            ProdutoQuantidade prod = new ProdutoQuantidade();
            prod.setProduto(produto);
            prod.adicionar(quantidade);
            produtos.add(prod);
        }
        recalcularValorTotalVenda();
    }

    public void recalcularValorTotalVenda() {
        BigDecimal valorTotal = BigDecimal.ZERO;
        for(ProdutoQuantidade produto : this.produtos){
            valorTotal = valorTotal.add(produto.getValorTotal());
        }
        this.valorTotal = valorTotal;
    }



    public void removerProduto(Produto produto,Integer quantidade) {
        validarStatus();
        Optional<ProdutoQuantidade> op =
                produtos.stream().filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();

        if (op.isPresent()) {
            ProdutoQuantidade produtoQtd = op.get();
            if (produtoQtd.getQuantidade() > quantidade) {
                produtoQtd.remover(quantidade);
                recalcularValorTotalVenda();
            } else {
                produtos.remove(op.get());
                recalcularValorTotalVenda();
            }

        }
    }

    public void removerTodosProdutos() {
        validarStatus();
        produtos.clear();
        valorTotal = BigDecimal.ZERO;
    }

    public Integer getQuantidadeTotalProdutos() {
        // Soma a quantidade getQuantidade() de todos os objetos ProdutoQuantidade
        int result = produtos.stream()
                .reduce(0, (partialCountResult, prod) -> partialCountResult + prod.getQuantidade(), Integer::sum);
        return result;
    }


    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Instant getData_venda() {
        return data_venda;
    }

    public void setData_venda(Instant data_venda) {
        this.data_venda = data_venda;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public void setProdutos(Set<ProdutoQuantidade> produtos) {
        this.produtos = produtos;
    }
}
