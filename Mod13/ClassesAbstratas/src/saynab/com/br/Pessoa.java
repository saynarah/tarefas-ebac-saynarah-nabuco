package saynab.com.br;

public abstract class Pessoa {

    //Propriedades Pessoa

    private String nome;

    private String sobrenome;

    private Integer ano_nascimento;

    //Getter and Setter das propriedades
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getAno_nascimento() {
        return ano_nascimento;
    }

    public void setAno_nascimento(Integer ano_nascimento) {
        this.ano_nascimento = ano_nascimento;
    }

    //Método de impressão abstrato
    public abstract void imprimirDados(String nome, String sobrenome, Integer ano_nascimento, String numero);
}
