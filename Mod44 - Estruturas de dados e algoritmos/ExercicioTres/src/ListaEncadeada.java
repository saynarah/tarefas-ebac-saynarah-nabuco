package src;


public class ListaEncadeada {

    private int[] numeros;

    public ListaEncadeada(int[] numeros) {
        this.numeros = numeros;
    }

    public Integer size() {
        Integer tamanho = 0;
        for (Integer numero : numeros) {
            tamanho++;
        }
        return tamanho;
    }

    public void insert(int index, int valor) {

        int tamanho = size()+1;
        int[] listAux = new int[tamanho];

        for(int i = 0; i < tamanho; i++){
            if(i == index){
                listAux[i] = valor;

            } else if (i > index){
                listAux[i] = numeros[i-1];
            }
            else {
                listAux[i] = numeros[i];
            }
        }

        this.numeros = listAux;
        printList();

    }

    public void remove(int index) {

        int tamanho = size()-1;
        int[] listAux = new int[tamanho];

        for(int i = 0; i < tamanho; i++){
            if(i >= index){
                listAux[i] = numeros[i+1];

            } else {
                listAux[i] = numeros[i];
            }
        }

        this.numeros = listAux;
        printList();

    }


    public void push( int node) {

        int tamanho = size()+1;
        int[] listAux = new int[tamanho];

        for(int i = 0; i < tamanho; i++){
            if(i == tamanho-1 ){
                listAux[i] = node;
            } else {
                listAux[i] = numeros[i];
            }
        }

        this.numeros = listAux;
        printList();

    }

    public int pop(){

        int tamanho = size()-1;
        int[] listAux = new int[tamanho];

        int lastNode = numeros[tamanho];

        for(int i = 0; i < tamanho; i++){

           listAux[i] = numeros[i];
        }


        this.numeros = listAux;
        printList();
        return lastNode;
    }

    public int elementAt(int index) throws Exception {
        try {
            int node = numeros[index];
            return node;
        }
        catch(Exception e){
            throw new Exception("Index excede o tamanho da lista");
        }

    }


    public String printList(){

        int tamanho = size();
        StringBuilder string = new StringBuilder();
        for(int i=0; i< tamanho;++i) {
            if (i == tamanho - 1) {
                string.append(numeros[i] + " -> null ");
            } else {
                string.append(numeros[i] + " -> (next) ");
            }
        }

        System.out.println(string);
        return String.valueOf(string);
    }
}
