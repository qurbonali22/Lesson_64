package com.example.controller;

import com.example.Student;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    private List<Student> studentList = new LinkedList<>();

    public StudentController() {

        studentList.add(new Student(UUID.randomUUID().toString(), "Alish", "Aliyev"));

    }

    @PostMapping("")
    public Student createStudent(@RequestBody Student student){
        student.setId(UUID.randomUUID().toString());
        studentList.add(student);
        return student;
    }
    
    @GetMapping("")
    public List<Student> getStudent(){

        return studentList;
    }


    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") String id){

        for (Student student : studentList) {
            if (student.getId().equals(id)){
                return student;
            }
        }

        return null;
    }

    @PutMapping("/{id}")
    public boolean updateStudent(@RequestBody Student student, @PathVariable("id") String id){

        for (Student s : studentList) {
            if (s.getId().equals(id)){
                s.setName(student.getName());
                s.setSurname(student.getSurname());
                return true;
            }
        }

        return false;
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable("id") String id){

        for (Student s : studentList) {
            if (s.getId().equals(id)){
                studentList.remove(s);
                return true;
            }
        }

        return false;
    }

}
