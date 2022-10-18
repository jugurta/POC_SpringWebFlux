package fr.acssi.demo.controller.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadParametersException extends RuntimeException {

    public BadParametersException() {
        super();
    }

    public BadParametersException(String message) {
        super(message);
    }
}