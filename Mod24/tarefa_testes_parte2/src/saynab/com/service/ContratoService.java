package saynab.com.service;

import saynab.com.dao.IContratoDao;

public class ContratoService implements IContratoService{

    private IContratoDao contratoDao;

    //construtor
    public ContratoService(IContratoDao contratoDao) {
        this.contratoDao = contratoDao;
    }

    @Override
    public String salvar() {
        return contratoDao.salvar();
        //return "Contrato salvo com sucesso";
    }

    @Override
    public String excluir() {
        return contratoDao.excluir();
        //return "Contrato excluído com sucesso";
    }

    @Override
    public String buscar() {
        return contratoDao.buscar();
        //return "Busca realizada com sucesso";
    }

    @Override
    public String atualizar() {
        return contratoDao.atualizar();
     //   return "Contrato atualizado com sucesso";
    }
}
