import Dao.CivicDAO;
import Dao.HondaDAO;
import Dao.generic.IGeneric;
import domain.Civic;
import domain.Honda;
import javax.swing.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class App {

        private static IGeneric<Honda> iGenericHondaDAO;
        private static IGeneric<Civic> iGenericCivicDAO;

        public static void main(String[] args) {

            iGenericCivicDAO = new CivicDAO();
            iGenericHondaDAO = new HondaDAO();

            String opcao = menuPrincipal();
            String entidadeEscolhida = "";

            while(!isOpcaoValida(opcao)){
               opcao = JOptionPane.showInputDialog(null,
                        "Opção Inválida! Digite 1 para cadastrar, digite 2 para listar veículos e digite 0 para sair.",
                        "Menu Principal",
                        JOptionPane.INFORMATION_MESSAGE);

            }

            while(isOpcaoValida(opcao)){
                String dados = "";
                if("0".equals(opcao)){
                    System.exit(0);
                }

                else if("1".equals(opcao)){
                    entidadeEscolhida = escolherEntidade();

                    dados = JOptionPane.showInputDialog(null,
                            "Insira as informações do veículo separados por vírgula:cor, modelo, ano, código",
                            "Cadastrar veículo",JOptionPane.INFORMATION_MESSAGE);
                    cadastrar(dados,entidadeEscolhida);

                   }

                else if("2".equals(opcao)){
                    //listar tudo
                    listar();
                }
                opcao = menuPrincipal();
            }


            }

    private static void listar() {
            System.out.println("Seguem os dados de " + iGenericCivicDAO.getClass());
            iGenericHondaDAO.buscarTodos();
            System.out.print(iGenericHondaDAO.buscarTodos());

            System.out.println("Seguem os dados de " + iGenericHondaDAO.getClass());
            iGenericHondaDAO.buscarTodos();
            System.out.println(iGenericHondaDAO.buscarTodos());

            }



    private static String escolherEntidade() {
            String[] opcoes = {"Civic","Honda"};
            Integer entidadeEscolhida = JOptionPane.showOptionDialog(null,
                    "Escolha uma marca de carro",
                    "Escolher veículo",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    opcoes [0]); //Civic é o default
        return opcoes[entidadeEscolhida];

    }

    private static String menuPrincipal() {
        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastrar, digite 2 para listar veículos e digite 0 para sair.",
                "Menu Principal",
                JOptionPane.INFORMATION_MESSAGE);
        return opcao;

    }

    private static Boolean isOpcaoValida(String opcao){
            if("".equals(opcao) || " ".equals(opcao)){
                return false;
            }
            else {
                return true;
            }
    }

    private static void cadastrar(String dados,String entidadeEscolhida) {
            String[] dadosSeparados = dados.split(",");

            if("Civic".equals(entidadeEscolhida)){
                Civic civic = new Civic(dadosSeparados[0],dadosSeparados[1],parseInt(dadosSeparados[2]),parseLong(dadosSeparados[3]));
                Boolean civicCadastrado = iGenericCivicDAO.cadastrar(civic);
                if(civicCadastrado){
                    JOptionPane.showMessageDialog(null,
                            "Veículo cadastrado com sucesso!");
                }
            }

            else if("Honda".equals(entidadeEscolhida)){
                Honda honda = new Honda(dadosSeparados[0],dadosSeparados[1],parseInt(dadosSeparados[2]),parseLong(dadosSeparados[3]));
                Boolean hondaCadastrado = iGenericHondaDAO.cadastrar(honda);
                if(hondaCadastrado){
                    JOptionPane.showMessageDialog(null,
                            "Veículo cadastrado com sucesso!");
                }
            }

    }


}