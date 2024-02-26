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
  @Test
  public void testAddStudent(){
    Student student = new Student();
    student.setFirstName("Nora");
    student.setLastName("Khan");
    student.setGrade("10");
    student.setClassTeacher("Katty");
    student.setPersonalInfo("Parents");
    student.setId(5);

    when(studentDao.addStudent(student)).thenReturn(student);

    Student students = studentService.addStudent(student);
    assertEquals("Nora", students.getFirstName());
    assertEquals("Khan", students.getLastName());
    assertEquals("Katty", students.getClassTeacher());
    assertEquals("10", students.getGrade());
    assertEquals("Parents", students.getPersonalInfo());
    assertEquals(5, students.getId()) ;


  }
  
}
