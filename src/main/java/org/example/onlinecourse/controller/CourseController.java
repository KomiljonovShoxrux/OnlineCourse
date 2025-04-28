package org.example.onlinecourse.controller;

import org.example.onlinecourse.dto.CourseDto;
import org.example.onlinecourse.model.Course;
import org.example.onlinecourse.model.Result;
import org.example.onlinecourse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;


    @GetMapping
    public HttpEntity<?> getall(){
        List<Course> courseList= courseService.getAllCourses();
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getone(@PathVariable Long id){
        Course course = courseService.getCourseById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody CourseDto courseDto){
        Result result = courseService.createCourse(courseDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id, @RequestBody CourseDto courseDto){
        Result result = courseService.updateCourse(id, courseDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id){
        Result result = courseService.deleteCourse(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
