import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>(List.of(10,20,30,40));
        Fila fila = new Fila(numeros);

        System.out.println("Return the size of the queue: ");
        System.out.println(fila.size().toString());

        System.out.println("Return if the queue is empty: ");
        System.out.println(fila.isEmpty().toString());

        System.out.println("Queue after the Enqueue method: ");
        System.out.println(fila.enqueue(70).toString());

        System.out.println("Queue after the Dequeue method: ");
        System.out.println(fila.dequeue().toString());

        System.out.println("Rear method - last integer in the queue: ");
        System.out.println(fila.rear());

        System.out.println("Front method - first integer in the queue: ");
        System.out.println(fila.front());


    }

}