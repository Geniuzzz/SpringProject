package com.springboot.springproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){
        return new Student("Okon", "Lagos");
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Okon", "Lagos"));
        students.add(new Student("Sam", "Uyo"));
        students.add(new Student("Udo", "Yes"));
        return students;
    }
}
