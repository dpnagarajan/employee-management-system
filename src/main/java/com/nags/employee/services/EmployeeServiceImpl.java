package com.nags.employee.services;

import com.nags.employee.entity.EmployeeEntity;
import com.nags.employee.model.Employee;
import com.nags.employee.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
  private EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository){
      this.employeeRepository=employeeRepository;
  }
    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
       employeeRepository.save(employeeEntity);
        return employee;
    }
}
