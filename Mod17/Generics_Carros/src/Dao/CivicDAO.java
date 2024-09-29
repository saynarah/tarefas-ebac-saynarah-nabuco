package Dao;


import Dao.generic.GenericDaO;
import domain.Civic;
import domain.Honda;

public class CivicDAO extends GenericDaO<Civic> implements ICivic {

    public CivicDAO(){
        super();
    }

    @Override
    public Class<Civic> getTipoClasse() {
        return Civic.class;
    }

    public void alterarDados(Civic entity, Civic entidadeCadastrada) {

        entidadeCadastrada.setCodigoCivic(entity.getCodigo());
        entidadeCadastrada.setAno(entity.getAno());
        entidadeCadastrada.setCor(entity.getCor());
        entidadeCadastrada.setModelo(entity.getModelo());

    }
}
