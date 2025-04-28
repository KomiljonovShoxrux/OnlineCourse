package org.example.onlinecourse.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.List;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String fullname;
    @Column(nullable = false)
    private Integer experienceYears;
    @Column(nullable = false)
    @Email
    private String email;
    @OneToMany
    private List<Course> course_id;

    public Instructor(Long id, String fullname, Integer experienceYears, String email, List<Course> course_id) {
        this.id = id;
        this.fullname = fullname;
        this.experienceYears = experienceYears;
        this.email = email;
        this.course_id = course_id;
    }

    public Instructor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Course> getCourse_id() {
        return course_id;
    }

    public void setCourse_id(List<Course> course_id) {
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", experienceYears=" + experienceYears +
                ", email='" + email + '\'' +
                ", course_id=" + course_id +
                '}';
    }
}
