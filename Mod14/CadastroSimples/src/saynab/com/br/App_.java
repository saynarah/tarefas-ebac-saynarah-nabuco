package saynab.com.br;

import saynab.com.br.dao.ClienteMapDAO;
import saynab.com.br.dao.IClienteDAO;
import saynab.com.br.domain.Cliente;

import javax.swing.*;

import static java.lang.Long.parseLong;

public class App_ {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = menuPrincipal();

        while (!isOpcaoValida(opcao)) {
            //Se a opção for vazio, vai para o método sair.
            if ("".equals(opcao)) {
                sair();
            }

            opcao = JOptionPane.showInputDialog(null,
                    "Opcao inválida! Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração e 5 para sair",
                    "Menu Principal",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)) {

            if (isOpcaoSair(opcao)) {
                sair();
            }

            else if (isCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados separados por vírgula, conforme exemplo (nome,cpf,telefone,rua,numero da rua,estado,cidade)",
                        "Cadastro",
                        JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
                opcao = menuPrincipal();

            }

            else if (isConsulta(opcao)) {
                String dado = JOptionPane.showInputDialog(null, "Digite o CPF cadastrado", "Consulta", JOptionPane.INFORMATION_MESSAGE);
                consultar(dado);
                opcao = menuPrincipal();


            }

            else if (isExclusao(opcao)){
                String dado = JOptionPane.showInputDialog(null, "Digite o CPF do cliente", "Excluir", JOptionPane.INFORMATION_MESSAGE);
                excluir(dado);
                opcao = menuPrincipal();
            }

            else if(isAlteracao(opcao)){
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados separados por vírgula, conforme exemplo (nome,cpf,telefone,rua,numero da rua,estado,cidade)",
                        "Atualização",
                        JOptionPane.INFORMATION_MESSAGE);
                atualizar(dados);
                opcao = menuPrincipal();
            }
        }

    }

    private static void atualizar(String dados) {
        //Tentar validar se os todos os campos foram preenchidos ou colocar os vazios como null no construtor
        String[] dadosSeparados = dados.split(",");
        Cliente cliente = new Cliente(dadosSeparados[0], Long.parseLong(dadosSeparados[1]), Long.parseLong(dadosSeparados[2]), dadosSeparados[3], Integer.parseInt(dadosSeparados[4]), dadosSeparados[5], dadosSeparados[6]);

        if (iClienteDAO.alterar(cliente) != null) {
            JOptionPane.showMessageDialog(null,
                    "Cliente alterado com sucesso" + cliente.toString(), "Sucesso" , JOptionPane.INFORMATION_MESSAGE);
        }

        else {
            JOptionPane.showMessageDialog(null, "Cliente não cadastrado!", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isAlteracao(String opcao) {
        if ("4".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static void excluir(String dado) {
        Cliente cliente = iClienteDAO.excluir(Long.parseLong(dado));
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!" + cliente.toString(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isExclusao(String opcao) {
        if ("3".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static void consultar(String dado) {
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dado));
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "O nome do cliente é:" + cliente.toString(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isConsulta(String opcao) {
        if ("2".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static String menuPrincipal() {
        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração e 5 para sair",
                "Green dinner",
                JOptionPane.INFORMATION_MESSAGE);
        return opcao;
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        Cliente cliente = new Cliente(dadosSeparados[0], parseLong(dadosSeparados[1]), parseLong(dadosSeparados[2]), dadosSeparados[3], Integer.parseInt(dadosSeparados[4]), dadosSeparados[5], dadosSeparados[6]);
        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
        if (isCadastrado) {
            JOptionPane.showMessageDialog(null,
                    "Cliente cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado!", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static boolean isCadastro(String opcao) {
            if ("1".equals(opcao)) {
                return true;
            }
            return false;
    }

    private static void sair() {
        String clientesCadastrados = "";
        for (Cliente cliente : iClienteDAO.buscarTodos()) {
            clientesCadastrados += cliente.toString() + "\n";
        }

        if (!clientesCadastrados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Clientes cadastrados" + clientesCadastrados);
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Sem clientes a serem exibidos.");
            System.exit(0);

        }
    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)) {
            return true;
        }
        return false;
    }


    private static boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)) {
            return true;
        }
        return false;
    }


}