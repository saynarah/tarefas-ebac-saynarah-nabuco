import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Base {

    public static void main(String[] args) {

        System.out.println("----------");
        System.out.println(" ");

        String input = "";
        do {
            //Recebe a lista de pessoas pelo console
            input = JOptionPane.showInputDialog(null,
                    "Insira uma lista de pessoas (Nome-Gênero) separando por vírgulas. Ex: Luana-F,Marco-M",
                    "Insira as pessoas",
                    JOptionPane.INFORMATION_MESSAGE);
        } while(input.equals(""));

        //Transforma a string em uma lista
        List<String> convertedlist = List.of(input.split(","));


        Object[] opcoes = { "Feminino", "Masculino" };

        //Caixa de diálogo para escolher o gênero de nomes na lista
        int escolha = JOptionPane.showOptionDialog(null,
                "Escolha um gênero para gerar a lista de nomes",
                "Escolha do Gênero",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);

        //if/else para gerar a lista de acordo com o gênero
        if(escolha == 0){
            Stream<String> listaMulheres = convertedlist.stream()
                    .filter(nome -> nome.endsWith("f"))
                    .map(nome -> nome.substring(0, nome.length() - 2));
            System.out.print(listaMulheres.toList());
        }

        else {
            Stream<String> listaMulheres = convertedlist.stream()
                    .filter(nome -> nome.endsWith("m"))
                    .map(nome -> nome.substring(0, nome.length() - 2));
            System.out.print(listaMulheres.toList());
        }

    }
}
