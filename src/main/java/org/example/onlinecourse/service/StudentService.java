package org.example.onlinecourse.service;

import org.example.onlinecourse.dto.StudentDto;
import org.example.onlinecourse.model.Enrollment;
import org.example.onlinecourse.model.Result;
import org.example.onlinecourse.model.Strudent;
import org.example.onlinecourse.repository.EnrollmentRepo;
import org.example.onlinecourse.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    EnrollmentRepo enrollmentRepo;



    public List<Strudent> getall(){
        return studentRepo.findAll();
    }
    public Strudent getById(Long id){
        return studentRepo.findById(id).get();
    }

    public Result add(StudentDto studentDto){
        boolean exists = studentRepo.existsById(studentDto.getEnrollment_id());
        if(exists){
            return new Result(false, "Student already exists");
        }

        Strudent strudent = new Strudent();
        strudent.setFullname(studentDto.getFullname());
        strudent.setEmail(studentDto.getEmail());
        strudent.setAge(studentDto.getAge());

        Optional<Enrollment> enrollmentOptional = enrollmentRepo.findById(studentDto.getEnrollment_id());
        Enrollment enrollment = enrollmentOptional.get();
        strudent.setEnrollment_id((List<Enrollment>) enrollment);
        studentRepo.save(strudent);
        return new Result(true, "Student added");
    }

    public Result update(Long id , StudentDto studentDto){
        Optional<Strudent> strudentOptional = studentRepo.findById(id);
        if(strudentOptional.isPresent()){
            Strudent strudent = strudentOptional.get();
            strudent.setFullname(studentDto.getFullname());
            strudent.setEmail(studentDto.getEmail());
            strudent.setAge(studentDto.getAge());

            Optional<Enrollment> enrollmentOptional = enrollmentRepo.findById(studentDto.getEnrollment_id());
            Enrollment enrollment = enrollmentOptional.get();
            strudent.setEnrollment_id((List<Enrollment>) enrollment);
            studentRepo.save(strudent);
            return new Result(true, "Student updated");
        }
        return new Result(false, "Student not found");
    }

    public Result delete(Long id){
        Optional<Strudent> strudentOptional = studentRepo.findById(id);
        if(strudentOptional.isPresent()){
            Strudent strudent = strudentOptional.get();
            studentRepo.delete(strudent);
            return new Result(true, "Student deleted");
        }
        return new Result(false, "Student not found");
    }

}
