
package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {

}
