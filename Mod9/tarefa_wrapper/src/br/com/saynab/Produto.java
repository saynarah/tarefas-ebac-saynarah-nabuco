package br.com.saynab;

public class Produto {

    private int valor;
    private Integer valor_wrapper;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Integer getValor_wrapper() {
        return valor_wrapper;
    }

    public void setValor_wrapper(Integer valor_wrapper) {
        this.valor_wrapper = valor_wrapper;
    }

    public void imprimirQuantidade(){
        System.out.println("O valor da variável primitiva é: "+ this.getValor());
        System.out.print("O valor do Wrapper é: " + this.valor_wrapper.intValue() );
    }
}
