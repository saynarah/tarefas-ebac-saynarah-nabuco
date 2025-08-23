import java.util.ArrayList;

public class Fila {

    private ArrayList<Integer> numeros;

    public Fila(ArrayList<Integer> numeros) {
        this.numeros = numeros;
    }

    public Integer size() {
        Integer tamanho = 0;
        for(Integer numero : numeros){
            tamanho++;
        }
        return tamanho;
    }

    public Boolean isEmpty(){

        Integer tamanho = size();

        if(tamanho >0){
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<Integer> enqueue(Integer inteiro){
        numeros.add(inteiro);
        ArrayList<Integer> newQueue = montarFila();
        return newQueue;
    }



    public ArrayList<Integer> dequeue(){
        numeros.remove(numeros.get(0));
        ArrayList<Integer> newQueue = montarFila();
        return newQueue;
    }

    public Integer rear(){
        Integer tamanho = size();
        Integer finalFila = montarFila().get(tamanho-1);
        return finalFila;
    }

    public Integer front(){
        Integer tamanho = size();
        int inicioFila = montarFila().get(0);
        return inicioFila;
    }


    private ArrayList<Integer> montarFila(){

        Integer tamanho = size();
        ArrayList<Integer> filaAux = new ArrayList<Integer>();

        for(int i=0; i < tamanho;i++ ){
            filaAux.add(i,numeros.get(i));
        }
        this.numeros = filaAux;
        return filaAux;
    }


}
