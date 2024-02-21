package com.employee.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.employee.dao.StudentDao;
import com.employee.dto.Student;



@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {

  @InjectMocks
  private StudentService studentService = new StudentServiceImpl() ;
    
  @Mock
  private StudentDao studentDao;

  @Test
  public void testGetStudentList(){
    Student student = new Student();
    student.setFirstName("Sam");

    List<Student> list = new ArrayList<>();
    list.add(student);

    when(studentDao.getStudentList()).thenReturn(list);
    List<Student> students = studentService.getStudentList();

    assertEquals("Sam", students.get(0).getFirstName());
    
  }
  
}
