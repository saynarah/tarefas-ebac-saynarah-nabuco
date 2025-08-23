package src;

public class Main {

    public static void main(String[] args) throws Exception {

        int[] numeros = {10,20,30,40};
        ListaEncadeada lista = new ListaEncadeada(numeros);

        System.out.println("List after the Insert method: ");
        lista.insert(2,17);

        System.out.println("List after the Remove method: ");
        lista.remove(2);

        System.out.println("Return element at a specific index: ");
        System.out.println(lista.elementAt(2));

        System.out.println("Return the size of the list: ");
        System.out.println(lista.size());

        System.out.println("List after the Push method: ");
        lista.push(100);

        System.out.println("List after the Pop method: ");
        lista.pop();

        System.out.println("Print List method: ");
        lista.printList();

    }

}
