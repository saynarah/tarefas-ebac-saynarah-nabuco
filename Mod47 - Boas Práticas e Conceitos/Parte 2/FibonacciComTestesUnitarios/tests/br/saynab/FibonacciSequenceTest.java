package br.saynab;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciSequenceTest {

    @Test
    public void testEncontrarElemento_HappyPath(){

        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        long resultado = fibonacciSequence.encontrarElementoPD(7);
        Assert.assertEquals(13L,resultado);

    }

    @Test
    public void testEncontrarElementoPosicaoZero(){

        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        long resultado = fibonacciSequence.encontrarElementoPD(0);
        Assert.assertEquals(0L,resultado);

    }

    @Test
    public void testEncontrarElementoPosicaoUm(){

        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        long resultado = fibonacciSequence.encontrarElementoPD(1);
        Assert.assertEquals(1L,resultado);

    }
}
