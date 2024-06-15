package br.com.saynab;

public class Notas {

    private static float nota1 = 8.5f;
    private static float nota2 = 7.6f;
    private static float nota3 = 9.4f;
    private static float nota4 = 6.3f;

    public static void main(String[] args) {

        calcularMedia();

    }

    private static void calcularMedia() {
        float media = (nota1+nota2+nota3+nota4)/4;
        System.out.println("As notas são: ");
        System.out.println(nota1);
        System.out.println(nota2);
        System.out.println(nota3);
        System.out.println(nota4);
        System.out.println("---------------------------------");
        System.out.print("A média é: " + media);
    }


}