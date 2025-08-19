import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int[] montarPilha(ArrayList<Integer> inteiros, Integer tamanho){
        int[] pilha = new int[tamanho];
        for(int i=0; i < tamanho;i++ ){
           pilha[tamanho-1 -i] = inteiros.get(i);
        }
        return pilha;
    }


    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(List.of(10,20,30,40));
        System.out.println(Arrays.toString(montarPilha(numeros,numeros.size())));

        System.out.println("Custom Push");
        System.out.println(Arrays.toString(customPush(70,numeros)));

        System.out.println("Custom Pop");
        System.out.println(Arrays.toString(customPop(numeros)));

        System.out.println("Custom Top");
        System.out.println(customTop(numeros));

        System.out.println("Custom isEmpty");
        System.out.println(customIsEmpty(numeros));

        System.out.println("Custom Size");
        System.out.println(customSize(numeros));

    }


    public static int[] customPush(Integer inteiro, ArrayList<Integer> numeros){
        numeros.add(inteiro);
        return montarPilha(numeros,numeros.size());

    }


    public static int[] customPop(ArrayList<Integer> numeros){
        Integer tamanhoPilha = numeros.size();
        numeros.remove(numeros.get(tamanhoPilha-1)); //remove the last number on the list which is the first number on the stack
        return montarPilha(numeros,numeros.size());

    }

    public static Integer customTop(ArrayList<Integer> numeros){
        Integer topStack = montarPilha(numeros,numeros.size())[0];
        return topStack;
    }

    public static Boolean customIsEmpty(ArrayList<Integer> numeros){
        if(numeros.size()==0){
            return true;
        } else {
            return false;
        }

    }

    public static Integer customSize(ArrayList<Integer> numeros){
        Integer size = 0;
        for (int i :numeros){
            size++;
        }
        return size;
    }

}