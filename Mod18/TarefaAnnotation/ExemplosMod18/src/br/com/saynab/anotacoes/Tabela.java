package br.com.saynab.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface Tabela {

    String nomeTabela();
}
