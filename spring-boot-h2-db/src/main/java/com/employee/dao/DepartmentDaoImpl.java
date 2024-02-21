package com.employee.dao;
import java.util.List;
import com.employee.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.employee.dto.Department;

@Component
public class DepartmentDaoImpl implements DepartmentDao {

  @Autowired
  DepartmentRepository departmentRepository;

  public List<Department> getDepartmentList() {
    return departmentRepository.findAll();
  }

  public Department addDepartment(Department department) {
    return departmentRepository.save(department);
  }
}
