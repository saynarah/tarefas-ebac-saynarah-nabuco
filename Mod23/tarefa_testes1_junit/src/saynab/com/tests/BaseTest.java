package saynab.com.tests;


import org.junit.Assert;
import org.junit.Test;
import saynab.com.base.Base;

import java.util.Arrays;
import java.util.List;

public class BaseTest {

    @Test
    public void testeEquallistamulheres(){
        Base base = new Base();
        List<String> listaResposta = Arrays.asList("luana", "maria", "sofia","fabia","monica");
        List<String> listaTeste = base.gerarLista("luana-f,marcelo-m,antonio-m,maria-f,miguel-m,sofia-f,fabia-f,igor-m,monica-f",0);

        Assert.assertEquals(listaResposta,listaTeste);
        System.out.println("Status Test Equal Lista Mulheres: " + "Teste realizado com sucesso! Resultado esperado atingindo.");

    }

    @Test
    public void testeNotEquallistamulheres(){
        Base base = new Base();
        List<String> listaResposta = Arrays.asList("luana", "maria", "sofia","fabia");
        List<String> listaTeste = base.gerarLista("luana-f,marcelo-m,antonio-m,maria-f,miguel-m,sofia-f,fabia-f,igor-m,monica-f",0);

        Assert.assertNotEquals(listaResposta,listaTeste);
        System.out.println("Status Test Not Equal Lista Mulheres: " +"Teste realizado com sucesso! Resultado esperado atingindo.");

    }
}


