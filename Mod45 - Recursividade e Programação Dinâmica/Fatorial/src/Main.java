public class Main {

    public static void main(String[] args) {

        int numero = 101;
        System.out.println("O fatorial de " + numero + " é: " + calcularFatorial(numero));
    }


    public static double calcularFatorial(int n) {

        if (n <= 1) {
            return 1;

        }
        else {
            return n * calcularFatorial(n - 1);
        }
    }

}


