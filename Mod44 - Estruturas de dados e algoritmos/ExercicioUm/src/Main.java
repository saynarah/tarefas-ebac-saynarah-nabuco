import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>(List.of(10,20,30,40));
        Stack stack = new Stack(numeros);

        System.out.println("Return the size of the stack: ");
        System.out.println(stack.size().toString());

        System.out.println("Return if the stack is empty: ");
        System.out.println(stack.isEmpty().toString());

        System.out.println("Element on the top of the stack: ");
        System.out.println(stack.top().toString());

        System.out.println("Pop method - Remove the number at the top of the stack: ");
        System.out.println(stack.pop().toString());


    }




}