package br.com.saynab;

import java.util.Scanner;

public class ResultadoAluno {

    public static float calcularMedia(float nota1, float nota2, float nota3, float nota4) {
        float media = (nota1+nota2+nota3+nota4)/4;

        System.out.println("---------------------------------");
        System.out.println("A média é: " + media);

        return media;
    }


    public static void validarResultado(float media) {
        if(media >= 7) {
            System.out.println("Aprovado!");
        }

        else if(media < 7 && media >=5) {
            System.out.println("Em recuperação!");
        }

        else {
            System.out.println("Reprovado!");
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        float[] notas = new float[4];

        for (int i=1; i<=4;i++) {
            System.out.print("Insira sua nota " + i + ": ");
            notas[i-1] = scanner.nextFloat();
        }

        //O resultado da média é colocado como parâmetro para o método de validação do resultado.
        validarResultado(calcularMedia(notas[0], notas[1], notas[2],notas[3]));

    }
}



