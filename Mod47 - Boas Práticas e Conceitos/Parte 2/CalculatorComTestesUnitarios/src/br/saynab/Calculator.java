package br.saynab;

public class Calculator {

    public int soma(int num1, int num2){
        return num1+num2;
    }

    public int subtracao(int num1, int num2){
        return num1 - num2;
    }

    public int multiplicacao(int num1, int num2){
        return num1 * num2;
    }

    /**
    O metodo de divisão só realiza a divisão se o denominador (num2) for diferente de zero.
     Caso (num2) = 0, retorna -1.
     **/

    public int divisao(int num1, int num2){
        if (divisaoEhPossivel(num2)){
            return num1/num2;
        }
        return -1;
    }

    private boolean divisaoEhPossivel (int num2){
        return num2 != 0 ? true : false;
    }

}
