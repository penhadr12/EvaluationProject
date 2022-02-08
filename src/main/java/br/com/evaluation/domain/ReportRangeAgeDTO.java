package br.com.evaluation.domain;

import br.com.evaluation.model.Employee;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
public class ReportRangeAgeDTO {

    private Employee younger;
    private Employee older;
    private Double average;

    public ReportRangeAgeDTO(Employee younger, Employee older) {

        this.younger = younger;
        this.older = older;
        this.average = (Period.between(younger.getBirthDate(), LocalDate.now()).getYears() + Period.between(older.getBirthDate(), LocalDate.now()).getYears()) / 2d;
    }
}
