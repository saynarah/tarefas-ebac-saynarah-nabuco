package main.java.domain;


import javax.persistence.*;

@Entity
@Table(name="produto")

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "produto_seq")
    @SequenceGenerator(name="produto_seq",sequenceName = "sq_produto",initialValue =1,allocationSize =1)
    private Long id;

    @Column(name = "codigo",length = 10,nullable = false,unique = true)
    private String codigo;

    @Column(name = "nome",length = 100,nullable = false)
    private String nome;

    @Column(name = "descricao",length = 200,nullable = false)
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
