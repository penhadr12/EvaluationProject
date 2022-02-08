package br.com.evaluation.advice;

import br.com.evaluation.controller.EmployeeController;
import br.com.evaluation.exception.EmployeeException;
import br.com.evaluation.exception.NotFoundException;
import br.com.evaluation.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@Slf4j
@RestControllerAdvice(assignableTypes = EmployeeController.class)
public class EmployeeAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = EmployeeException.class)
    public ResponseEntity<Optional<Employee>> parameterInternalError(RuntimeException exception) {
        log.error("{}", exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Optional<Employee>> parameterNotFound(NotFoundException exception) {
        log.error("{}", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}