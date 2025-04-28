package org.example.onlinecourse.service;

import org.example.onlinecourse.dto.EnrollmentDto;
import org.example.onlinecourse.model.Course;
import org.example.onlinecourse.model.Enrollment;
import org.example.onlinecourse.model.Result;
import org.example.onlinecourse.model.Strudent;
import org.example.onlinecourse.repository.CourseRepo;
import org.example.onlinecourse.repository.EnrollmentRepo;
import org.example.onlinecourse.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    EnrollmentRepo enrollmentRepo;
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    StudentRepo studentRepo;


    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepo.findAll();
    }
    public Enrollment getEnrollmentById(Long  id) {
        return enrollmentRepo.findById(id).get();
    }

    public Result addEnrollment(EnrollmentDto enrollmentDto) {
        boolean exists = enrollmentRepo.existsById(enrollmentDto.getCourse_id());
        if (exists) {
            return new Result(false, "Enrollment already exists");
        }
        Enrollment enrollment = new Enrollment();

        Optional<Course> course = courseRepo.findById(enrollmentDto.getCourse_id());
        Course courseObj = course.get();
        enrollment.setCourse_id(courseObj);

        Optional<Strudent> strudentOptional = studentRepo.findById(enrollmentDto.getStrudent_id());
        Strudent strudentObj = strudentOptional.get();
        enrollment.setStrudent_id(strudentObj);
        enrollmentRepo.save(enrollment);
        return new Result(true, "Enrollment added");
    }

    public Result updateEnrollment(Long id , EnrollmentDto enrollmentDto) {
        Optional<Enrollment> enrollmentOptional = enrollmentRepo.findById(id);
        if (enrollmentOptional.isPresent()) {
            Enrollment enrollment = new Enrollment();

            Optional<Course> course = courseRepo.findById(enrollmentDto.getCourse_id());
            Course courseObj = course.get();
            enrollment.setCourse_id(courseObj);

            Optional<Strudent> strudentOptional = studentRepo.findById(enrollmentDto.getStrudent_id());
            Strudent strudentObj = strudentOptional.get();
            enrollment.setStrudent_id(strudentObj);
            enrollmentRepo.save(enrollment);
            return new Result(true, "Enrollment updated");
        }
        return new Result(false, "Enrollment not found");
    }

    public Result deleteEnrollment(Long id) {
        Optional<Enrollment> enrollmentOptional = enrollmentRepo.findById(id);
        if (enrollmentOptional.isPresent()) {
            Enrollment enrollment = enrollmentOptional.get();
            enrollmentRepo.delete(enrollment);
            return new Result(true, "Enrollment deleted");
        }
        return new Result(false, "Enrollment not found");

    }

}
