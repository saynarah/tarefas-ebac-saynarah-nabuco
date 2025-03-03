package br.com.saynab.domain;

import br.com.saynab.anotacao.ColunaTabela;
import br.com.saynab.anotacao.Tabela;
import br.com.saynab.anotacao.TipoChave;

@Tabela(nome = "TB_CLIENTE")
public class Cliente implements Persistente{

    @ColunaTabela(dbName = "id",setJavaName = "setId")
    private Long id;

    @ColunaTabela(dbName = "nome",setJavaName = "setNome")
    private String nome;

    @TipoChave("getCpf")
    @ColunaTabela(dbName = "cpf", setJavaName = "setCpf")
    private Long cpf;

    @ColunaTabela(dbName = "tel",setJavaName = "setTel")
    private Long tel;

    @ColunaTabela(dbName = "rua", setJavaName = "setRua")
    private String rua;

    @ColunaTabela(dbName = "numero_rua",setJavaName = "setNumero_rua")
    private Integer numero_rua;

    @ColunaTabela(dbName = "cidade",setJavaName = "setCidade")
    private String cidade;

    @ColunaTabela(dbName = "estado",setJavaName = "setEstado")
    private String estado;

    @ColunaTabela(dbName = "email",setJavaName = "setEmail")
    private String email;

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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero_rua() {
        return numero_rua;
    }

    public void setNumero_rua(Integer numero_rua) {
        this.numero_rua = numero_rua;
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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
