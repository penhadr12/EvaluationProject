package br.com.evaluation.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String mensage) {
        super(mensage);
    }
}