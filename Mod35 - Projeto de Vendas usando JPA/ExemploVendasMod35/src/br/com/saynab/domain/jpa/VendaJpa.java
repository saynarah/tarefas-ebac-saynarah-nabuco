package br.com.saynab.domain.jpa;

import br.com.saynab.domain.Persistente;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "TB_VENDA")
public class VendaJpa implements Persistente {


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {

    }

    public enum Status {
        INICIADA,
        CONCLUIDA,
        CANCELADA;

        public static Status getByName(String value){
            for (Status status : Status.values()) {
                if(status.name().equals(value)){
                    return status;
                }
            }
            return null;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="venda_seq")
    @SequenceGenerator(name="venda_seq",sequenceName = "sq_venda",initialValue=1,allocationSize=1)
    private Long id;

    @Column(name = "CODIGO",nullable = false,unique =true)
    private String codigo;

    @ManyToOne
    @JoinColumn(name="id_cliente_fk",
                foreignKey = @ForeignKey(name = "fk_venda_cliente"),
                referencedColumnName = "id",nullable = false)

    private ClienteJpa cliente;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private Set<ProdutoQuantidadeJpa> produtos;

    @Column(name = "VALOR_TOTAL",nullable = false)
    private BigDecimal valorTotal;

    @Column(name = "DATA_VENDA", nullable = false)
    private Instant dataVenda;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_VENDA", nullable = false)
    private Status status;

    public VendaJpa() {
        produtos = new HashSet<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ClienteJpa getCliente() {
        return cliente;
    }

    public void setCliente(ClienteJpa cliente) {
        this.cliente = cliente;
    }

    public Set<ProdutoQuantidadeJpa> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<ProdutoQuantidadeJpa> produtos) {
        this.produtos = produtos;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Instant getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Instant dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void adicionarProduto(ProdutoJpa produto, Integer quantidade) {
        validarStatus();

        Optional<ProdutoQuantidadeJpa> op =
                produtos.stream().filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();

        if(op.isPresent()){
            ProdutoQuantidadeJpa produtoQtd = op.get(); //.get() metodo nativo com o uso do Optional
            produtoQtd.adicionar(quantidade);
        } else {
            ProdutoQuantidadeJpa prod = new ProdutoQuantidadeJpa();
            prod.setVenda(this);
            prod.setProduto(produto);
            prod.adicionar(quantidade);
            produtos.add(prod);
        }
        recalcularValorTotalVenda();

    }

    public void recalcularValorTotalVenda() {
        BigDecimal valorTotal = BigDecimal.ZERO;
        for(ProdutoQuantidadeJpa prod : this.produtos){
            valorTotal = valorTotal.add(prod.getValorTotal());

        }
        this.valorTotal = valorTotal;
    }

    private void validarStatus() {
        if(this.status == Status.CONCLUIDA){
            throw new UnsupportedOperationException("Impossível alterar venda finalizada");
        }
    }

    public void removerProduto(ProdutoJpa produto, Integer quantidade) {
        validarStatus();
        Optional<ProdutoQuantidadeJpa> op =
                produtos.stream().filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();

        if (op.isPresent()) {
            ProdutoQuantidadeJpa produtoQtd = op.get();
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


}
