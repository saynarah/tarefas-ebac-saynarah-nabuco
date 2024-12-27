package saynab.com.dao;

public class ContratoDaoMock implements IContratoDao{


    @Override
    public String salvar() {
        return "Contrato salvo com sucesso";
    }

    @Override
    public String excluir() {
        return "Contrato excluído com sucesso";
    }

    @Override
    public String buscar() {
        return "Busca realizada com sucesso";
    }

    @Override
    public String atualizar() {
        return "Contrato atualizado com sucesso";
    }
}

