package br.com.saynab.domain.jpa;

import br.com.saynab.domain.Persistente;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_PRODUTO_QUANTIDADE")
public class ProdutoQuantidadeJpa implements Persistente{


        @Id
        @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="venda_seq")
        @SequenceGenerator(name="venda_seq", sequenceName="sq_venda", initialValue = 1, allocationSize = 1)
        private Long id;

        @ManyToOne(cascade = CascadeType.ALL)
        private ProdutoJpa produto;

        @Column(name = "quantidade",nullable = false)
        private Integer quantidade;

        @Column(name = "valor_total",nullable = false)
        private BigDecimal valorTotal;


        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "id_venda_fk",
                    foreignKey = @ForeignKey(name = "fk_prod_qtd_venda"),
                    referencedColumnName = "id", nullable = false)
        private VendaJpa venda;


        public ProdutoQuantidadeJpa() {
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

        public ProdutoJpa getProduto() {
        return produto;
        }

        public void setProduto(ProdutoJpa produto) {
        this.produto = produto;
        }

        public VendaJpa getVenda() {
        return venda;
        }

        public void setVenda(VendaJpa venda) {
        this.venda = venda;
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


