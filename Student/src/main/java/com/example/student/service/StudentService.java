package com.example.student.service;

import com.example.student.entity.Student;

import java.util.List;

public interface StudentService {
     public List<Student> getStudentList();
     public Student saveStudentDetails(Student student);
     public void deleteStudent(Long id);
     public Student getStudentById(Long id);
     Student updateStudent(Student student);
}
