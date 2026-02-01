package br.saynab;

public class FibonacciSequence {

    private static final int MAX_ELEMENTOS = 100;
    private static final long[] elementosFib = new long[MAX_ELEMENTOS];

    public long encontrarElementoPD(int elementNumber){

        for(int i=0;i< MAX_ELEMENTOS;i++){
            elementosFib[i] = -1;
        }

        return encontrarElemento(elementNumber);

    }

    public long encontrarElemento(int elementNumber){

        if (elementosFib[elementNumber] == -1){
            if(elementNumber <= 1){
                elementosFib[elementNumber] = elementNumber;
            }

            else {
                elementosFib[elementNumber] = encontrarElemento(elementNumber-1) + encontrarElemento(elementNumber-2);
            }
        }
        return elementosFib[elementNumber];

    }

}
