package main.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TB_CARRO")
public class Carro implements Persistent{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "car_seq")
    @SequenceGenerator(name="car_seq",sequenceName = "sq_car",initialValue = 1,allocationSize = 1)
    private Integer id;

    @Column(name = "codigo",length = 10,nullable = false,unique = true)
    private String codigo;

    @Column(name ="ano_lancamento",nullable = false)
    private Integer ano_lançamento;

    @ManyToOne
    @JoinColumn(
            name="id_marca_fk",
            foreignKey = @ForeignKey(name="fk_carro_marca"),
            referencedColumnName = "id",nullable = false)
    private Marca marca;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="tb_carro_acessorio",
            joinColumns = @JoinColumn(name="id_marca_fk"),
            inverseJoinColumns = @JoinColumn(name="id_acessorio_fk")
            )
    private List<Acessorio> acessorios;

    public Carro() {
        this.acessorios = new ArrayList<Acessorio>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getAno_lançamento() {
        return ano_lançamento;
    }

    public void setAno_lançamento(Integer ano_lançamento) {
        this.ano_lançamento = ano_lançamento;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public void adicionarAcessorio(Acessorio acessorio) {
        this.acessorios.add(acessorio);
    }
}
