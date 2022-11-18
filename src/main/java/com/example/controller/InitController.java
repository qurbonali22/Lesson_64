package com.example.controller;

import ch.qos.logback.core.BasicStatusManager;
import com.example.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@RestController
public class InitController {

        private List<Student> studentList = new LinkedList<>();

    public InitController() {

        studentList.add(new Student(UUID.randomUUID().toString(), "Alish", "Aliyev"));

    }

//    @RequestMapping(value = "/current_time", method = RequestMethod.GET)
//    @RequestBody

    @GetMapping(value = "/current_time")
    public LocalDateTime currentTime(){
        return  LocalDateTime.now();
    }

//    @RequestMapping(value = "/message", method = RequestMethod.GET)

    @GetMapping("/message")
    public String message(){
        return  "salom";
    }

//    @RequestMapping(value = "/pow/{num}", method = RequestMethod.GET)

    @GetMapping("/pow/{num}")
    public String pow(@PathVariable("num") Integer number){
        return  "Result : " + Math.pow(number, 2);
    }

//    @RequestMapping(value = "/student", method = RequestMethod.POST)




}
