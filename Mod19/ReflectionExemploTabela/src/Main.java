import Anotacao.Tabela;

public class Main {
    public static void main(String[] args) {

        ClasseComAnotacao classeComAnotacao = new ClasseComAnotacao();
        Tabela tabela = classeComAnotacao.getClass().getAnnotation(Tabela.class);
        System.out.println("");
        System.out.println(tabela.nomeTabela());
    }
}