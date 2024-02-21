package com.employee.dao;
import com.employee.dto.Student;
import java.util.List;

public interface StudentDao {
    public List<Student> getStudentList();

    public Student addStudent(Student student);

}
