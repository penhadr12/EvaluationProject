package br.com.evaluation.controller;

import br.com.evaluation.domain.ReportRangeAgeDTO;
import br.com.evaluation.domain.ReportRangeSalaryDTO;
import br.com.evaluation.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/age")
    public ResponseEntity<ReportRangeAgeDTO> reportSalary() {
        log.info("report of range age");
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getReportAge());
    }

    @GetMapping("/employees/salary")
    public ResponseEntity<ReportRangeSalaryDTO> reportAge() {
        log.info("report of range salary");
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getReportSalary());
    }


}
