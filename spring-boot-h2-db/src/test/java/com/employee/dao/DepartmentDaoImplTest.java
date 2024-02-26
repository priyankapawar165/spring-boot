package com.employee.dao;

import com.employee.dto.Department;
import com.employee.repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentDaoImplTest {

    @InjectMocks
    private DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Mock
    private DepartmentRepository departmentRepository;

    @Test
    public void teGetDepartmentList(){
        Department department = new Department();
        department.setDeptName("IT");
        when(departmentRepository.findAll()).thenReturn(List.of(department));
        List<Department> departmentList = departmentDao.getDepartmentList();
        assertEquals("IT", departmentList.get(0).getDeptName());

    }
    @Test
    public void testAddDepartment(){
        Department department = new Department();
        department.setDeptName("Fashion");
        department.setId(1);
        when(departmentRepository.save(department)).thenReturn(department);
        Department actualDepartment = departmentDao.addDepartment(department);
        assertEquals("Fashion", actualDepartment.getDeptName());
        assertEquals(1, actualDepartment.getId());
    }
}
