package saynab.com.br;

public class PessoaFísica extends Pessoa {

    //Propriedade PessoaFisica
    private String cpf_numero;

    //Getter and Setter Propriedades
    public String getCpf_numero() {
        return cpf_numero;
    }

    public void setCpf_numero(String cpf_numero) {
        this.cpf_numero = cpf_numero;
    }

    //Método da classe abstrata Pessoa
    @Override
    public void imprimirDados(String nome, String sobrenome,Integer ano, String numero) {

        System.out.println("***************");
        System.out.println("Pessoa cadatrada se chama: " + nome + " " + sobrenome);
        System.out.println("Tipo de cadastro: " + this.getClass().getSimpleName());
        System.out.println("Ano de nascimento:" + ano);
        System.out.println("CPF:" + numero);
        System.out.println("***************");

    }
}
