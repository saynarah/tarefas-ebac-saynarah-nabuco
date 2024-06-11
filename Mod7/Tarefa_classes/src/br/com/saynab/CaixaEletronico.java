package br.com.saynab;

/**
 * @author Saynarah Nabuco
 * @version v1.0.0
 *
 */


public class CaixaEletronico {

    private int code;
    private String model;
    private String currency;
    private boolean is_24_horas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isIs_24_horas() {
        return is_24_horas;
    }

    public void setIs_24_horas(boolean is_24_horas) {
        this.is_24_horas = is_24_horas;
    }

    /**
     * Este método informa o funcionamento do caixa eletrônico
     *
     */

    public void informarFuncionamento(){
        System.out.println("Funcionamento 24 horas? " + this.is_24_horas);
    }

    /**
     * Este método informa a moeda disponível no caixa eletronico
     */
    public void imprimirMoeda() {
        System.out.println("Moeda disponível: " + this.currency);
    }


}






