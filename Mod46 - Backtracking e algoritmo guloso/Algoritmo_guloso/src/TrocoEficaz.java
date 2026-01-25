

public class TrocoEficaz {

    public static int[] realizarTroco(int[] moedas, int valorTroco){

        //int[] moedasOrdemDecrescente = ordenarMoedas(int[] moedas);

        boolean trocoFinalizado = false;
        int valorTrocoRemanescente = valorTroco; //inicia com o valor do troco
        int cont = 0;
        int[] contagemMoedas = new int[moedas.length];

        while (!trocoFinalizado){

            for(int i =0;i<moedas.length;i++) {
                cont = 1;

                while(cont>0) {

                    if (valorTrocoRemanescente >= (cont*moedas[i])){
                        cont = cont+1;
                    }

                    else {
                    cont = cont - 1; //recuperar último valor válido

                    valorTrocoRemanescente = valorTrocoRemanescente - (cont*moedas[i]);

                    contagemMoedas[i] = cont; // só arma
                    cont = 0;
                    }
                }

                if(valorTrocoRemanescente == 0){
                    trocoFinalizado = true;
                    break; //não precisa conferir o restante das moedas, visto que o troco já foi finalizado
                }

            }
        }

        return contagemMoedas;


    }

    public static void imprimirResultado(int[] moedas, int[] contagemMoedas){

        for(int i =0;i<moedas.length;i++) {

            if(contagemMoedas[i] >0) {
                System.out.println(contagemMoedas[i] + " moeda(s) de " + moedas[i] + " reais");
            }
        }
    }

    public static int[] ordenarMoedas(int[] moedas) {

        int[] moedasDesordenadas = moedas;
        int[] moedasOrdenadas = new int[moedas.length];
        int indiceMaiorNumero = 0;

        for (int j = 0; j < moedasDesordenadas.length; j++) {
            int aux = moedasDesordenadas[j];
            for (int i = 0; i < moedasDesordenadas.length; i++) {
                if (aux < moedasDesordenadas[i]) {
                    aux = moedasDesordenadas[i];
                    indiceMaiorNumero = i;
                }
                moedasOrdenadas[j] = aux;

            }
            moedasDesordenadas[indiceMaiorNumero] = 0;
        }
        return moedasOrdenadas;
    }



    public static void main(String[] args){
        int[] moedas = {1,2,3,5}; //as moedas podem vir embaralhadas

        int valorTroco = 18;

        int[] moedasOrdemDecrescente = ordenarMoedas(moedas);

        int[] contagemMoedasTroco = realizarTroco(moedasOrdemDecrescente,valorTroco);
        System.out.println();
        System.out.println("O menor número de moedas para realizar o troco de " + valorTroco + " reais é:");

        imprimirResultado(moedasOrdemDecrescente,contagemMoedasTroco);

    }




}

