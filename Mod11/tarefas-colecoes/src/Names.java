import java.util.*;

public class Names {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String raw_names;


        //Ler os dados do console
        System.out.print("Insira os nomes separados por vírgula:"); 

        raw_names = scanner.nextLine();

        System.out.println("**** Lista de nomes fornecida **** ");
        System.out.println(raw_names);
        System.out.println();

        //Chama o método para separar os nomes e imprime de forma ordenada
        System.out.println("**** Lista de nomes em ordem alfabética **** ");

        System.out.println(splitNames(raw_names));
        System.out.println();
    }

    private static List<String> splitNames(String raw_names) {

        List<String> names = new ArrayList<>();
        //Salva na variável quantos itens a lista tem
        int qtdeNames = raw_names.split(",").length;

        //adiciona cada item na lista
        for (int i = 0; i < qtdeNames; i++) {
            names.add(raw_names.split(",")[i]);
        }

        //ordena os nomes pelo nome em ordem alfabética
        Collections.sort(names);

        return names;
    }
}

