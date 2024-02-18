package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.DepartmentDao;
import com.employee.dto.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService{

  @Autowired
  DepartmentDao departmentDao;

  public List<Department> getDepartmentList(){
    return departmentDao.getDepartmentList();
  }
}
