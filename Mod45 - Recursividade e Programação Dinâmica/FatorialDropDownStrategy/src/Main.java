public class Main {

        private static final int MAX = 105;

        private static double[] elemFatorial = new double[MAX + 1];

        public static void main(String[] args){
        int numero = 101;
        System.out.println("O fatorial de " + numero + " é: " + encontrarElementoPO(numero));
}


        public static double encontrarElementoPO(int n){
            for(int i = 0; i<= n;i++){
                elemFatorial[i] = -1;
            }


            if(n<= 1){
                elemFatorial[n] = 1;
                return 1;
            }

            if (elemFatorial[n] == -1) {
                elemFatorial[n] = n * encontrarElementoPO(n - 1);
            }

            return elemFatorial[n];

            }
        }




