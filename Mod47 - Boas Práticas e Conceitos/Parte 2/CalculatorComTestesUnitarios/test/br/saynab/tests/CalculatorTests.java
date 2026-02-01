package br.saynab.tests;

import org.junit.Assert;
import org.junit.Test;

import br.saynab.Calculator;

public class CalculatorTests {

    @Test
    public void testSoma_HappyPath(){

        Calculator calculadora = new Calculator();
        int resultadoSoma = calculadora.soma(1,2);
        Assert.assertEquals(3,resultadoSoma);
    }

    @Test
    public void testSubtracao_HappyPath(){

        Calculator calculadora = new Calculator();
        int resultadoSubtracao = calculadora.subtracao(7,5);
        Assert.assertEquals(2,resultadoSubtracao);
    }

    @Test
    public void testMultiplicacao_HappyPath(){

        Calculator calculadora = new Calculator();
        int resultadoMultiplicacao = calculadora.multiplicacao(2,6);
        Assert.assertEquals(12,resultadoMultiplicacao);
    }

    @Test
    public void testDivisao_HappyPath(){

        Calculator calculadora = new Calculator();
        int resultadoDivisao = calculadora.divisao(10,2);
        Assert.assertEquals(5,resultadoDivisao);
    }

    @Test
    public void testDivisaoPorZero(){

        Calculator calculadora = new Calculator();
        int resultadoDivisaoPorZero = calculadora.divisao(10,0);
        Assert.assertEquals(-1,resultadoDivisaoPorZero);
    }




}
