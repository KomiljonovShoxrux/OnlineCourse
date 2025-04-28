package org.example.onlinecourse.service;

import org.example.onlinecourse.dto.CourseDto;
import org.example.onlinecourse.model.Course;
import org.example.onlinecourse.model.Instructor;
import org.example.onlinecourse.model.Result;
import org.example.onlinecourse.repository.CourseRepo;
import org.example.onlinecourse.repository.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {


    @Autowired
    CourseRepo courseRepo;
    @Autowired
    InstructorRepo instructorRepo;


    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public Course getCourseById(Long id){
        return courseRepo.findById(id).get();
    }

    public Result createCourse(CourseDto courseDto) {
        boolean exists = courseRepo.existsById(courseDto.getInstructor_id());
        if(exists){
            return new Result(false, "Course already exists");
        }

        Course course = new Course();
        course.setKursnomi(courseDto.getKursnomi());
        course.setDescription(courseDto.getDescription());
        course.setKursdavomiyligi(courseDto.getKursdavomiyligi());

        Optional<Instructor> instructorOptional = instructorRepo.findById(courseDto.getInstructor_id());
        Instructor instructor = instructorOptional.get();
        course.setInstructor_id(instructor);
        courseRepo.save(course);
        return new Result(true, "Course created");
    }

    public Result updateCourse(Long id, CourseDto courseDto) {
        Optional<Course> courseOptional = courseRepo.findById(id);
        if(courseOptional.isPresent()){
            Course course = courseOptional.get();
            course.setKursnomi(courseDto.getKursnomi());
            course.setDescription(courseDto.getDescription());
            course.setKursdavomiyligi(courseDto.getKursdavomiyligi());

            Optional<Instructor> instructorOptional = instructorRepo.findById(courseDto.getInstructor_id());
            Instructor instructor = instructorOptional.get();
            course.setInstructor_id(instructor);
            courseRepo.save(course);
            return new Result(true, "Course updated");
        }
        return new Result(false, "Course not found");
    }

    public Result deleteCourse(Long id) {
        Optional<Course> courseOptional = courseRepo.findById(id);
        if(courseOptional.isPresent()){
            courseRepo.delete(courseOptional.get());
            return new Result(true, "Course deleted");

        }
        return new Result(false, "Course not found");
    }

}
