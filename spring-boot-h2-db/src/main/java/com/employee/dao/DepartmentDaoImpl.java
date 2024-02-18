package com.employee.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.employee.dto.Department;

@Component
public class DepartmentDaoImpl implements DepartmentDao {

  public List<Department> getDepartmentList(){

    Department department = new Department();

    List<Department> departmentList = new ArrayList<>();

    department.setDeptName("IT");
    department.setDeptSize("100000");
    department.setDeptHead("Chandni");
    departmentList.add(department);

    return departmentList;
}

  
}
