package test;

import main.dao.IMarcaDAO;
import main.dao.MarcaDAO;
import main.domain.Marca;
import org.junit.Assert;
import org.junit.Test;

public class MarcaTest {

    private IMarcaDAO marcaDAO;

    public MarcaTest() {
        this.marcaDAO = new MarcaDAO();
    }

    @Test
    public void criarMarcaTest(){
        Marca marca = new Marca();
        marca.setCodigo("M2");
        marca.setNome("BMW");

        Marca marcaCadastrada = marcaDAO.cadastrar(marca);
        Assert.assertNotNull(marcaCadastrada);
    }

}
