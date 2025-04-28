package org.example.onlinecourse.service;

import org.example.onlinecourse.dto.InstructorDto;
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
public class InstructorService {

    @Autowired
    InstructorRepo instructorRepo;
    @Autowired
    CourseRepo courseRepo;



    public List<Instructor> findAll() {
        return instructorRepo.findAll();
    }

    public Instructor findById(Long id) {
        return instructorRepo.findById(id).get();
    }

    public Result save(InstructorDto instructorDto){
        boolean exists = instructorRepo.existsById(instructorDto.getCourse_id());
        if(exists){
            return new Result(false, "This course already exists");
        }

        Instructor instructor = new Instructor();
        instructor.setFullname(instructorDto.getFullname());
        instructor.setEmail(instructorDto.getEmail());
        instructor.setExperienceYears(instructorDto.getExperienceYears());
        instructorRepo.save(instructor);

        Optional<Course> courseOptional=  courseRepo.findById(instructorDto.getCourse_id());
        Course course = courseOptional.get();
        instructor.setCourse_id((List<Course>) course);
        instructorRepo.save(instructor);
        return new Result(true, "Instructor saved");
    }

    public Result update(Long id , InstructorDto instructorDto){
        Optional<Instructor> instructorOptional= instructorRepo.findById(id);
        if (instructorOptional.isPresent()){
            Instructor instructor = instructorOptional.get();
            instructor.setFullname(instructorDto.getFullname());
            instructor.setEmail(instructorDto.getEmail());
            instructor.setExperienceYears(instructorDto.getExperienceYears());

            Optional<Course> courseOptional=  courseRepo.findById(instructorDto.getCourse_id());
            Course course = courseOptional.get();
            instructor.setCourse_id((List<Course>) course);
            instructorRepo.save(instructor);
            return new Result(true, "Instructor updated");
        }
        return new Result(false, "Instructor not found");
    }

    public Result delete(Long id){
        Optional<Instructor> instructorOptional= instructorRepo.findById(id);
        if (instructorOptional.isPresent()){
            Instructor instructor = instructorOptional.get();
            instructorRepo.delete(instructor);
            return new Result(true, "Instructor deleted");
        }
        return new Result(false, "Instructor not found");

    }


}
