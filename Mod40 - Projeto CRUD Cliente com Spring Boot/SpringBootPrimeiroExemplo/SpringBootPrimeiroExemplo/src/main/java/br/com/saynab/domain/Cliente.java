package br.com.saynab.domain;


import javax.persistence.*;

@Entity
@Table(name= "TB_CLIENTE")
public class Cliente {

    public Cliente() {}

    public Cliente(Long id, String nome, Long cpf, Long tel, String end, Integer numero, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.tel = tel;
        this.end = end;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cliente_seq")
    @SequenceGenerator(name = "cliente_seq",sequenceName = "sq_cliente",initialValue = 1,allocationSize = 1)
    private Long id;

    @Column(name = "NOME",nullable = false, length = 50)
    private String nome;

    @Column(name = "CPF",nullable = false, unique = true)
    private Long cpf;

    @Column(name = "TEL",nullable = false)
    private Long tel;

    @Column(name = "ENDERECO",nullable = false,length = 100)
    private String end;

    @Column (name = "NUMERO",nullable = false)
    private Integer numero;

    @Column (name = "CIDADE",nullable = false,length = 100)
    private String cidade;

    @Column (name = "ESTADO",nullable = false, length = 50)
    private String estado;

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

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
