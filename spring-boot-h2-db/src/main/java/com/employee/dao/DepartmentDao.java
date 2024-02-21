package com.employee.dao;

import java.util.List;

import com.employee.dto.Department;

public  interface DepartmentDao {
  public List<Department> getDepartmentList();

  public Department addDepartment (Department department);

}
