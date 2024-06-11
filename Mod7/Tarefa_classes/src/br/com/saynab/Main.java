package br.com.saynab;

public class Main {


    public static void main (String args[] ){
        CaixaEletronico caixaEletronico = new CaixaEletronico();
        caixaEletronico.setIs_24_horas(true);
        caixaEletronico.setCurrency("Dollar");
        System.out.println("Principais características do objeto:");
        caixaEletronico.informarFuncionamento();
        caixaEletronico.imprimirMoeda();

    }
}
