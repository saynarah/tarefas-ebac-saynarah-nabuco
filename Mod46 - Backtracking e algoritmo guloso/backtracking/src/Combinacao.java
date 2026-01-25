import java.util.*;

public class Combinacao {


        static List<List<Integer>> resultado = new ArrayList<>();

        static void gerar(int inicio, List<Integer> atual, int tamanhoAmostra, List<Integer> numeros) {
            if (atual.size() == tamanhoAmostra) {
                resultado.add(new ArrayList<>(atual));
                return;
            }
            for (int i = inicio; i < 5; i++) {
                atual.add(numeros.get(i));
                gerar(i + 1, atual,tamanhoAmostra,numeros);
                atual.remove(atual.size() - 1);
            }
        }

        public static void main(String[] args) {

            List<Integer> numeros = new ArrayList<>(List.of(1,2,3,4,5));
            int tamanhoAmostra = 4;

            gerar(0,new ArrayList<>(),tamanhoAmostra,numeros);

            System.out.println("Total: " + resultado.size());  // 5
            for (List<Integer> comb : resultado) {
                System.out.println(comb);
            }
        }
    }

