package com.employee.service;

import com.employee.dao.StudentDao;
import com.employee.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    public List<Student> getStudentList(){
      return studentDao.getStudentList();
  }

  public Student addStudent(Student student){
    return studentDao.addStudent(student);
   }



}
