package domain;

public abstract class Carro {

    private String cor;
    private String modelo;
    private Integer ano;

    public Carro(String cor, String modelo, Integer ano) {
        this.cor = cor;
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
