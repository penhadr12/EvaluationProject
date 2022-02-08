package br.com.evaluation.domain;

import br.com.evaluation.model.Employee;
import lombok.Data;

@Data
public class ReportRangeSalaryDTO {

    private Employee lowest;
    private Employee highest;
    private Double average;

    public ReportRangeSalaryDTO(Employee lowest, Employee highest) {
        this.lowest = lowest;
        this.highest = highest;
        this.average = (lowest.getSalary() + highest.getSalary()) / 2;
    }
}
