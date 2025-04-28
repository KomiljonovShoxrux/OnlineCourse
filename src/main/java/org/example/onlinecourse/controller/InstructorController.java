package org.example.onlinecourse.controller;

import org.example.onlinecourse.dto.InstructorDto;
import org.example.onlinecourse.model.Instructor;
import org.example.onlinecourse.model.Result;
import org.example.onlinecourse.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @GetMapping
    public HttpEntity<?> getall(){
        List<Instructor> instructors = instructorService.findAll();
        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getone(@PathVariable Long id){
        Instructor instructor = instructorService.findById(id);
        return new ResponseEntity<>(instructor, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> save(@RequestBody InstructorDto instructorDto){
        Result result = instructorService.save(instructorDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id, @RequestBody InstructorDto instructorDto){
        Result result = instructorService.update(id, instructorDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id){
        Result result = instructorService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}
