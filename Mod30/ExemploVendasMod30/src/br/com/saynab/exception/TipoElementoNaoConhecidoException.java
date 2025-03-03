package br.com.saynab.exception;

public class TipoElementoNaoConhecidoException extends RuntimeException {

    public TipoElementoNaoConhecidoException() {
    }

    public TipoElementoNaoConhecidoException(String message) {
        super(message);
    }

    public TipoElementoNaoConhecidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
