package org.example.onlinecourse.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
public class Strudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String fullname;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private String email;
    @OneToMany
    private List<Enrollment> enrollment_id;

    public Strudent(Long id, String fullname, Integer age, String email, List<Enrollment> enrollment_id) {
        this.id = id;
        this.fullname = fullname;
        this.age = age;
        this.email = email;
        this.enrollment_id = enrollment_id;
    }

    public Strudent() {
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

    public List<Enrollment> getEnrollment_id() {
        return enrollment_id;
    }

    public void setEnrollment_id(List<Enrollment> enrollment_id) {
        this.enrollment_id = enrollment_id;
    }

    @Override
    public String toString() {
        return "Strudent{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", enrollment_id=" + enrollment_id +
                '}';
    }
}
