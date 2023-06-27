package org.employee.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.employee.entity.Employee;
import org.employee.entity.EmployeeEntity;
import org.employee.entity.EmployeeMapper;
import org.employee.entity.ValidationGroups;
import org.employee.entity.ValidationGroups.CreateEmployee;
import org.employee.entity.ValidationGroups.UpdateEmployee;
import org.employee.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class EmployeeService {

  @Autowired(required = false)
  private EmployeeMapper mapper;

  @Autowired
  private EmployeeDao employeeDao;

  @Transactional
  @Validated(CreateEmployee.class)
  public Long create(@Valid EmployeeEntity  employee) {

    //   EmployeeEntity employeeEntity = mapper.toEmployeeEntity(employee);
    employeeDao.save(employee);
    return employee.getId();
  }

  @Transactional
  @Validated(UpdateEmployee.class)
  public void update(@Valid Employee employee) {
    EmployeeEntity employeeEntity = mapper.toEmployeeEntity(employee);
    employeeDao.save(employeeEntity);
  }

  @Transactional(readOnly = true)
  public Employee getById(@NotNull Long id) {
    EmployeeEntity employeeEntity = employeeDao.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Employee not found for given id"));
    return mapper.toEmployee(employeeEntity);
  }

  @Transactional
  public void deleteById(@NotNull Long id) {
    System.out.println("tests");
    EmployeeEntity employeeEntity = employeeDao.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Employee not found for given id"));
    employeeDao.delete(employeeEntity);
  }
  
  public Iterable<EmployeeEntity> getEmployeeList(){
    return employeeDao.findAll();
  }

}
