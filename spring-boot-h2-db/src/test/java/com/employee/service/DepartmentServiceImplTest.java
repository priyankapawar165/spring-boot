package com.employee.service;

import com.employee.dao.DepartmentDao;
import com.employee.dto.Department;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    @InjectMocks
    private DepartmentService departmentService = new DepartmentServiceImpl() ;

    @Mock
    private DepartmentDao departmentDao;

    @Test
    public void testGetDepartmentList(){
        Department department = new Department();
        department.setDeptName("R&D");

        List <Department> departmentList = new ArrayList<>();
        departmentList.add(department);

        when(departmentDao.getDepartmentList()).thenReturn(departmentList);
        List<Department> departments = departmentService.getDepartmentList();
        assertEquals("R&D", departments.get(0).getDeptName());
    }


}
