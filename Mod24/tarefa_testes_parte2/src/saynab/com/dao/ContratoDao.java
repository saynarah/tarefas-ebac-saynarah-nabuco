package saynab.com.dao;

public class ContratoDao implements IContratoDao{

    private String messagemErro = "Sem acesso ao banco de dados";

    @Override
    public String salvar() {
        throw new UnsupportedOperationException(messagemErro);
    }

    @Override
    public String excluir() {
        throw new UnsupportedOperationException(messagemErro);
    }

    @Override
    public String buscar() {
        throw new UnsupportedOperationException(messagemErro);
    }

    @Override
    public String atualizar() {
        throw new UnsupportedOperationException(messagemErro);
    }
}
