package saynab.com.br;

public class Main {
    public static void main(String[] args) {

        //Criando Pessoa Física
        PessoaFísica pessoaFisica = new PessoaFísica();
        pessoaFisica.setCpf_numero("01234567890");
        pessoaFisica.setNome("Jade");
        pessoaFisica.setSobrenome("Barbosa");
        pessoaFisica.setAno_nascimento(1994);
        pessoaFisica.imprimirDados(pessoaFisica.getNome(), pessoaFisica.getSobrenome(), pessoaFisica.getAno_nascimento(), pessoaFisica.getCpf_numero());

        //Criando Pessoa Jurídica
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setCnpj_numero("12345678098644");
        pessoaJuridica.setNome("Fernando");
        pessoaJuridica.setSobrenome("Santos");
        pessoaJuridica.setAno_nascimento(1982);
        pessoaJuridica.imprimirDados(pessoaJuridica.getNome(), pessoaJuridica.getSobrenome(), pessoaJuridica.getAno_nascimento(), pessoaJuridica.getCnpj_numero());


    }
}