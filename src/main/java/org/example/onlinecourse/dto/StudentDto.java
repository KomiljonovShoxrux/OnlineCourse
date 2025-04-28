package org.example.onlinecourse.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import org.example.onlinecourse.model.Enrollment;

import java.util.List;

public class StudentDto {
    @Column(nullable = false)
    private String fullname;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private String email;
    @OneToMany
    private Long enrollment_id;

    public StudentDto(String fullname, Integer age, String email, Long enrollment_id) {
        this.fullname = fullname;
        this.age = age;
        this.email = email;
        this.enrollment_id = enrollment_id;
    }

    public StudentDto() {
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getEnrollment_id() {
        return enrollment_id;
    }

    public void setEnrollment_id(Long enrollment_id) {
        this.enrollment_id = enrollment_id;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "fullname='" + fullname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", enrollment_id=" + enrollment_id +
                '}';
    }
}
