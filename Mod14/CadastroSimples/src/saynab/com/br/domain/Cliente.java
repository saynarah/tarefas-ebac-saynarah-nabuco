package saynab.com.br.domain;

import java.util.Objects;

public class Cliente {

    private String nome;
    private Long cpf;
    private Long tel;
    private String rua;
    private Integer numero_rua;
    private String cidade;
    private String estado;

    public Cliente(String nome, Long cpf, Long tel, String rua, Integer numero_rua, String cidade, String estado) {
        this.nome = nome;
        this.cpf = cpf;
        this.tel = tel;
        this.rua = rua;
        this.numero_rua = numero_rua;
        this.cidade = cidade;
        this.estado = estado;
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
    public int hashCode() {
        int hash =7;
        hash = 79 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        //No contexto do método equals, o uso de final para a variável
        // other simplesmente significa que, uma vez que other tenha
        // sido atribuído, ela não pode ser alterada.
        final Cliente other = (Cliente) obj;
        if(!Objects.equals(this.cpf,other.cpf)){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                '}';
    }
}
