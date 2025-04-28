package org.example.onlinecourse.controller;

import org.example.onlinecourse.dto.StudentDto;
import org.example.onlinecourse.model.Result;
import org.example.onlinecourse.model.Strudent;
import org.example.onlinecourse.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StrudentController {

    @Autowired
    StudentService studentService;


    @GetMapping
    public HttpEntity<?> getStudent() {
        List<Strudent> strudents= studentService.getall();
        return new ResponseEntity<>(strudents, HttpStatus.OK);
    }

    @GetMapping("/api/students/{id}")
    public HttpEntity<?> getStudentById(@PathVariable Long id) {
        Strudent strudent = studentService.getById(id);
        return new ResponseEntity<>(strudent, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> addStudent(@RequestBody StudentDto studentDto) {
        Result result  = studentService.add(studentDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping("/api/students/{id}")
    public HttpEntity<?> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        Result result  = studentService.update(id, studentDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/api/students/{id}")
    public HttpEntity<?> deleteStudent(@PathVariable Long id) {
        Result result  = studentService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
