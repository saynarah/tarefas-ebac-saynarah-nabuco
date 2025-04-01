package main.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio implements Persistent{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "acessorio_seq")
    @SequenceGenerator(name="acessorio_seq",sequenceName="sq_acessorio",initialValue = 1,allocationSize=5)
    private Long id;

    @Column(name="codigo",length=10,nullable=false,unique=true)
    private String codigo;

    @Column(name="nome",nullable=false)
    private String nome;

    @Column(name="quantidade",nullable=false)
    private Integer quantidade;

    @ManyToMany(mappedBy = "acessorios")
    private List<Carro> carros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
}
