package br.com.saynab.exception;

public class MaisDeUmRegistroException extends Exception {

    public MaisDeUmRegistroException() {
    }

    public MaisDeUmRegistroException(String message) {
        super(message);
    }

    public MaisDeUmRegistroException(String message, Throwable cause) {
        super(message, cause);
    }
}
