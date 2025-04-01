package test;

import main.dao.*;
import main.domain.Acessorio;
import main.domain.Carro;
import main.domain.Marca;
import org.junit.Assert;
import org.junit.Test;

public class CarroTest {

    private ICarroDAO carroDAO;
    private IMarcaDAO marcaDAO;
    private IAcessorioDAO accessorioDAO;

    public CarroTest() {
        this.carroDAO = new CarroDAO();
        this.marcaDAO = new MarcaDAO();
        this.accessorioDAO = new AcessorioDAO();
    }

    @Test
    public void criarCarro(){

        Marca marca = criarMarca();
        Acessorio acessorio = criarAcessorio();
        Carro carro = new Carro();

        carro.setCodigo("A1");
        carro.setAno_lançamento(2010);
        carro.setMarca(marca);
        carro.adicionarAcessorio(acessorio);
        Carro carroCadastrado = carroDAO.cadastrar(carro);

        Assert.assertNotNull(carroCadastrado);

    }

    private Marca criarMarca(){
        Marca marca = new Marca();
        marca.setCodigo("M1");
        marca.setNome("Ferrari");
        return marcaDAO.cadastrar(marca);
    }

    private Acessorio criarAcessorio(){
        Acessorio acessorio = new Acessorio();
        acessorio.setCodigo("Ac1");
        acessorio.setNome("Aro");
        acessorio.setQuantidade(4);
        return acessorio;

    }

}
