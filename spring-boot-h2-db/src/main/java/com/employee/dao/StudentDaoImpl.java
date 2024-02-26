package com.employee.dao;
import com.employee.dto.Student;
import com.employee.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class StudentDaoImpl implements StudentDao {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudentList() {

        return studentRepository.findAll();
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);

    }

}
