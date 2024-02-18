package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employee.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
