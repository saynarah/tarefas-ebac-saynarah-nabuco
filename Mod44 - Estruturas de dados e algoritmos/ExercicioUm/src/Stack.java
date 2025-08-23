import java.util.ArrayList;

public class Stack {

    private ArrayList<Integer> numeros;

    public Stack(ArrayList<Integer> numeros) {
        this.numeros = numeros;
        this.numeros = montarPilha();
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

    public void push(Integer inteiro){

        numeros.add(inteiro);
        Integer tamanho = size();

        ArrayList<Integer> stackAux = new ArrayList<Integer>();

        stackAux.add(0,numeros.get(tamanho-1)); //coloca o número no topo da pilha

        for(int i=1;i<tamanho;i++){

            stackAux.add(i,numeros.get(i-1));

        }
        this.numeros = stackAux;
    }

    public Integer pop(){

        Integer numberRemoved = numeros.get(0);
        numeros.remove(0);
        return numberRemoved;

    }


    public Integer top(){
        Integer topStack = numeros.get(0);
        return topStack;
    }

    private ArrayList<Integer> montarPilha(){

        Integer tamanho = size();

        ArrayList<Integer> stackAux = new ArrayList<Integer>();

        for(int i=tamanho-1; i >=0;i-- ){

            stackAux.add(tamanho-1-i,numeros.get(i));
        }
        return stackAux;
    }


}
