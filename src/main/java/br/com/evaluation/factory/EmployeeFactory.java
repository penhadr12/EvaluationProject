package br.com.evaluation.factory;

import br.com.evaluation.domain.EmployeeDTO;
import br.com.evaluation.model.Employee;

public interface EmployeeFactory {

    static void updateEmployee(Employee employee, EmployeeDTO employeeDTO){
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setBirthDate(employeeDTO.getBirthDate());
        employee.setSalary(employeeDTO.getSalary());
    }

    static Employee createEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setBirthDate(employeeDTO.getBirthDate());
        employee.setSalary(employeeDTO.getSalary());
        return employee;
    }

}
