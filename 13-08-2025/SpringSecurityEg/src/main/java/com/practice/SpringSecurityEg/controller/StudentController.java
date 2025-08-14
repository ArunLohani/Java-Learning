package com.practice.SpringSecurityEg.controller;

import com.practice.SpringSecurityEg.model.Student;
import com.practice.SpringSecurityEg.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return service.getAllStudents();

    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request){

        return (CsrfToken) request.getAttribute("_csrf");

    }

    @PostMapping("/students")
    public List<Student> addStudent(@RequestBody Student stu){
        return service.addStudent(stu);
    }

}
