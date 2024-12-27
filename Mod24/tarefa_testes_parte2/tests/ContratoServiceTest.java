import org.junit.Assert;
import org.junit.Test;
import saynab.com.dao.ContratoDao;
import saynab.com.dao.ContratoDaoMock;
import saynab.com.dao.IContratoDao;
import saynab.com.service.ContratoService;
import saynab.com.service.IContratoService;

public class ContratoServiceTest {


    @Test
    public void testandoMetodoAtualizar(){
        IContratoDao contratoDao = new ContratoDaoMock();
        IContratoService contrato = new ContratoService(contratoDao);
        String retorno = contrato.atualizar();
        Assert.assertEquals("Contrato atualizado com sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperandoErroMetodoAtualizar(){
        IContratoDao contratoDao = new ContratoDao();
        IContratoService contrato = new ContratoService(contratoDao);
        String retorno = contrato.atualizar();
        Assert.assertEquals("Contrato atualizado com sucesso", retorno);
    }

    @Test
    public void testandoMetodoExcluir(){
        IContratoDao contratoDao = new ContratoDaoMock();
        IContratoService contrato = new ContratoService(contratoDao);
        String retorno = contrato.excluir();
        Assert.assertEquals("Contrato excluído com sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperandoErroMetodoExcluir(){
        IContratoDao contratoDao = new ContratoDao();
        IContratoService contrato = new ContratoService(contratoDao);
        String retorno = contrato.excluir();
        Assert.assertEquals("Contrato excluído com sucesso", retorno);
    }

    @Test
    public void testandoMetodoBuscar(){
        IContratoDao contratoDao = new ContratoDaoMock();
        IContratoService contrato = new ContratoService(contratoDao);
        String retorno = contrato.buscar();
        Assert.assertEquals("Busca realizada com sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperandoErroMetodoBuscar(){
        IContratoDao contratoDao = new ContratoDao();
        IContratoService contrato = new ContratoService(contratoDao);
        String retorno = contrato.buscar();
        Assert.assertEquals("Busca realizada com sucesso", retorno);
    }

    @Test
    public void testandoMetodoSalvar(){
        IContratoDao contratoDao = new ContratoDaoMock();
        IContratoService contrato = new ContratoService(contratoDao);
        String retorno = contrato.salvar();
        Assert.assertEquals("Contrato salvo com sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperandoErroMetodoSalvar(){
        IContratoDao contratoDao = new ContratoDao();
        IContratoService contrato = new ContratoService(contratoDao);
        String retorno = contrato.salvar();
        Assert.assertEquals("Contrato salvo com sucesso", retorno);
    }

}