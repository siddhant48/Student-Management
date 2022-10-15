package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public void check(){
       System.out.println("SidChour is here!!");
       return ;
    }

    @GetMapping("/student")
    public String getStudent(Model model){
        model.addAttribute("student",studentService.getStudentList());
        System.out.println("student-get");
        return "index";
    }
    @GetMapping("/form")
    public String fillDetailsInForm(Model model){
        Student student=new Student();
        model.addAttribute("student",student);
        System.out.println("form-get");
        return "createStudent";
    }

    @PostMapping("/student")
    public String createNewStudent(@ModelAttribute("student")Student student){
        studentService.saveStudentDetails(student);
        System.out.println("Data saved !!!");
        System.out.println("student-post");
        return "redirect:/student";
    }

    @GetMapping("/student/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/student";
    }

    @GetMapping("/student/updateStudent/{id}")
    public String updateStudent(@PathVariable Long id, Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "updateStudent";
    }

    @PostMapping("/student/updateStudent/{id}")
    public String updateStudentPost(@ModelAttribute("student")Student student,
                                    @PathVariable Long id){
        Student student1=studentService.getStudentById(id);
        student1.setId(id);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        studentService.updateStudent(student1);
        return "redirect:/student";
    }

}
