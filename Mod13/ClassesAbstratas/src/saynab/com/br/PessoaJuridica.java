package saynab.com.br;

public class PessoaJuridica extends Pessoa{

    //Propriedade PessoaJuridica
    private String cnpj_numero;

    //Getter and Setter PessoaJuridica
    public String getCnpj_numero() {
        return cnpj_numero;
    }

    public void setCnpj_numero(String cnpj_numero) {
        this.cnpj_numero = cnpj_numero;
    }

    //Método da classe abstrata Pessoa
    @Override
    public void imprimirDados(String nome, String sobrenome,Integer ano, String numero) {

        System.out.println("***************");
        System.out.println("Pessoa cadatrada se chama: " + nome + " " + sobrenome);
        System.out.println("Tipo de cadastro: " + this.getClass().getSimpleName());
        System.out.println("Ano de nascimento:" + ano);
        System.out.println("CNPJ:" + numero);
        System.out.println("***************");

    }
}
