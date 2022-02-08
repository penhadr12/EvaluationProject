package br.com.evaluation.service;

import br.com.evaluation.domain.EmployeeDTO;
import br.com.evaluation.domain.ReportRangeAgeDTO;
import br.com.evaluation.domain.ReportRangeSalaryDTO;
import br.com.evaluation.exception.NotFoundException;
import br.com.evaluation.factory.EmployeeFactory;
import br.com.evaluation.model.Employee;
import br.com.evaluation.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findById(Long id) throws NotFoundException{
        return employeeRepository.findById(id).orElseThrow(()-> new NotFoundException(String.format("Not found information of id: %d", id)));
    }

    public Iterable<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO){
        Employee employee = findById(id);
        EmployeeFactory.updateEmployee(employee,employeeDTO);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.delete(findById(id));
    }

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        return employeeRepository.save(Objects.requireNonNull(EmployeeFactory.createEmployee(employeeDTO)));
    }

    public ReportRangeSalaryDTO getReportSalary() throws NotFoundException{

        Collection<Employee> collection = (Collection<Employee>) getAll();

        Employee lowest = new Employee();
        Employee highest = new Employee();

        lowest = collection.stream().min((o1, o2) -> (int) (o1.getSalary() - o2.getSalary())).orElse(lowest);
        highest = collection.stream().max((o1, o2) -> (int) (o1.getSalary() - o2.getSalary())).orElse(highest);

        return new ReportRangeSalaryDTO(lowest, highest);
    }


    public ReportRangeAgeDTO getReportAge() throws NotFoundException{

        Collection<Employee> collection = (Collection<Employee>) getAll();

        Employee younger = new Employee();
        Employee older = new Employee();

        younger = collection.stream().min(this::compareTo).orElse(younger);
        older = collection.stream().max(this::compareTo).orElse(older);

        return new ReportRangeAgeDTO(younger, older);
    }

    public int compareTo(Employee o1, Employee o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }

}
