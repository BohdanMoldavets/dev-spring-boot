package com.moldavets.demo.rest;

import com.moldavets.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();

        students.add(new Student("John", "Doe"));
        students.add(new Student("Joe", "Kim"));
        students.add(new Student("Zhang", "Young"));
    }

    @GetMapping("/students")
    public List<Student> students() {
        return students;
    }

    @GetMapping("/students/{studentID}")
    public Student student(@PathVariable int studentID) {

        if ((studentID >= students.size()) || (studentID < 0)) {
            throw new StudentNotFoundException("Student not found - " + studentID);
        }
        return students.get(studentID);
    }
}
