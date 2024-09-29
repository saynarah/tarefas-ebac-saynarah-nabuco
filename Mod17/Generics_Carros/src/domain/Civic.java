package domain;

public class Civic extends Carro implements Persistente {

    private Long codigoCivic;

    public Civic(String cor, String modelo, Integer ano, Long codigoCivic) {
        super(cor,modelo,ano);
        this.codigoCivic = codigoCivic;
    }

    public void setCodigoCivic(Long codigoCivic) {
        this.codigoCivic = codigoCivic;
    }

    public Long getCodigo(){
        return this.codigoCivic;
    }

    @Override
    public String toString() {
        return "Civic{" +
                "codigoCivic=" + codigoCivic +
                ", modeloCivic='" + getModelo() + '\'' +
                ", cor='" + getCor() + '\'' +
                ", ano=" + getAno() +
                '}';
    }

}
