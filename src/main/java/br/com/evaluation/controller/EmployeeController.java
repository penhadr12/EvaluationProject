package br.com.evaluation.controller;

import br.com.evaluation.domain.EmployeeDTO;
import br.com.evaluation.model.Employee;
import br.com.evaluation.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<Iterable<Employee>> getAll() {
        log.info("fetch all employees");
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAll());
    }

    @GetMapping("/{id}/id")
    public ResponseEntity<Employee> findById(@PathVariable("id") Long id) {
        log.info("fetch employee by id: {}", id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findById(id));
    }

    @PutMapping("/{id}/id")
    public ResponseEntity<Employee> update(@PathVariable("id") Long id,
                                            @Validated @RequestBody EmployeeDTO employeeDTO) {
        log.info("update employee: {}", employeeDTO);
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(id, employeeDTO));
    }

    @DeleteMapping("/{id}/id")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        log.info("delete employee by id: {}", id);
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Employee> create(@Validated @RequestBody EmployeeDTO flightLeg) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(flightLeg));
    }

}
