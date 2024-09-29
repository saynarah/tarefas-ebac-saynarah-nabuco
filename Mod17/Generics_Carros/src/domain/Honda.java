package domain;

public class Honda extends Carro implements Persistente {

    private Long codigoHonda;

    public Honda(String cor, String modelo, Integer ano, Long codigoHonda) {
        super(cor, modelo, ano);
        this.codigoHonda = codigoHonda;
    }

    public void setCodigoHonda(Long codigoHonda) {
        this.codigoHonda = codigoHonda;
    }

    public Long getCodigo(){
        return this.codigoHonda;
    }

    @Override
    public String toString() {
        return "Honda{" +
                "codigoHonda=" + codigoHonda +
                ", modeloCivic='" + getModelo() + '\'' +
                ", cor='" + getCor() + '\'' +
                ", ano=" + getAno() +
                '}';
    }

}
