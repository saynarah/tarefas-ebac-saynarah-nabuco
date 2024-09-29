package Dao;


import Dao.generic.GenericDaO;

import domain.Honda;

public class HondaDAO extends GenericDaO<Honda> implements IHonda {

    public HondaDAO(){
        super();
    }

    @Override
    public Class<Honda> getTipoClasse() {
        return Honda.class;
    }

    public void alterarDados(Honda entity, Honda entidadeCadastrada) {

        entidadeCadastrada.setCodigoHonda(entity.getCodigo());
        entidadeCadastrada.setAno(entity.getAno());
        entidadeCadastrada.setCor(entity.getCor());
        entidadeCadastrada.setModelo(entity.getModelo());

    }
}
