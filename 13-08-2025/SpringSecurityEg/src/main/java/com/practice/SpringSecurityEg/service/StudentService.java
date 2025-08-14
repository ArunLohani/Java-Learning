package com.practice.SpringSecurityEg.service;

import com.practice.SpringSecurityEg.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1 , "Arun",90),
            new Student(2,"Lohani",95)
    )
    );


    public List<Student> getAllStudents (){

        return students;
    }

    public List<Student> addStudent(Student stu){
        students.add(stu);
        return getAllStudents();
    }

}
