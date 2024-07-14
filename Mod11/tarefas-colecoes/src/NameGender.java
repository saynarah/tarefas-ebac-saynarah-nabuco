import java.util.*;

public class NameGender {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String raw_names_gender;

        //Ler os dados do console
        System.out.print("Insira nome e gênero no seguinte formato 'Luana-F','Fabiano-M': ");
        System.out.println();

        raw_names_gender = scanner.nextLine();

        System.out.println("**** Dados fornecidos **** ");
        System.out.println(raw_names_gender);
        System.out.println();


        System.out.println("**** Lista de nomes em ordem alfabética e por grupo**** ");
        System.out.println();

        //Chama o método para separar os nomes por gênero e imprime de forma ordenada
        splitNamesGender(raw_names_gender);

    }

    private static void splitNamesGender(String raw_names_gender) {

        List<String> names_feminino = new ArrayList<>();
        List<String> names_masculino = new ArrayList<>();
        List<String> genero_nao_identificado = new ArrayList<>();

        //Salva na variável quantos itens a lista tem
        int qtdeNames = raw_names_gender.split(",").length;

        //testa cada par nome-gender para alocar no grupo certo
        for (int i = 0; i < qtdeNames; i++) {
            String element = raw_names_gender.split(",")[i];

            //split do par (nome,genero) e testa se o genero é F ou M
            if (element.split("-")[1].equalsIgnoreCase("F")) {
                names_feminino.add(element.split("-")[0]);

            } else if (element.split("-")[1].equalsIgnoreCase("M")) {
                names_masculino.add(element.split("-")[0]);

                //exceção para os casos somente com o nome sem a identificacao de genero
            } else {
                genero_nao_identificado.add(element.split("-")[0]);
            }
        }

        Collections.sort(names_feminino);
        Collections.sort(names_masculino);
        Collections.sort(genero_nao_identificado);

        System.out.println("**** Lista de nomes do grupo feminino**** ");
        System.out.println(names_feminino);
        System.out.println();

        System.out.println("**** Lista de nomes do grupo masculino**** ");
        System.out.println(names_masculino);
        System.out.println();

        System.out.println("**** Lista de nomes sem gênero identificado**** ");
        System.out.println(genero_nao_identificado);
        System.out.println();



    }
}