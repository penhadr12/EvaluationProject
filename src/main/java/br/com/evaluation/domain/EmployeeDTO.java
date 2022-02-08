package br.com.evaluation.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class EmployeeDTO {

    @NotNull
    Long id;
    @NotNull
    String name;
    @NotNull
    String  email;
    @NotNull
    String  department;
    @NotNull
    Double  salary;
    @NotNull
    LocalDate birthDate;
}
