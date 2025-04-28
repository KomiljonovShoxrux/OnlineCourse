package org.example.onlinecourse.dto;

import jakarta.persistence.OneToMany;
import org.example.onlinecourse.model.Course;

import java.util.List;

public class InstructorDto {


    private String fullname;
    private Integer experienceYears;
    private String email;
    @OneToMany
    private Long course_id;

    public InstructorDto(String fullname, Integer experienceYears, String email, Long course_id) {
        this.fullname = fullname;
        this.experienceYears = experienceYears;
        this.email = email;
        this.course_id = course_id;
    }

    public InstructorDto() {
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return "InstructorDto{" +
                "fullname='" + fullname + '\'' +
                ", experienceYears=" + experienceYears +
                ", email='" + email + '\'' +
                ", course_id=" + course_id +
                '}';
    }
}
