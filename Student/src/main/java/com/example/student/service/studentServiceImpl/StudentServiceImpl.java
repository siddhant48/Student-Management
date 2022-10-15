package com.example.student.service.studentServiceImpl;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getStudentList(){
        List<Student>studentList=studentRepository.findAll();
        return studentList;
    }

    @Override
    public Student saveStudentDetails(Student student){
        studentRepository.save(student);
        return student;
    }

    @Override
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    @Override
    public Student getStudentById(Long id){
      return  studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student){
        return studentRepository.save(student);

    }
}
