package org.example.onlinecourse.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Strudent strudent_id;
    @ManyToOne
    private Course course_id;
    @CreatedDate
    private LocalDateTime enrollmentDate;

    public Enrollment(Long id, Strudent strudent_id, Course course_id, LocalDateTime enrollmentDate) {
        this.id = id;
        this.strudent_id = strudent_id;
        this.course_id = course_id;
        this.enrollmentDate = enrollmentDate;
    }

    public Enrollment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Strudent getStrudent_id() {
        return strudent_id;
    }

    public void setStrudent_id(Strudent strudent_id) {
        this.strudent_id = strudent_id;
    }

    public Course getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Course course_id) {
        this.course_id = course_id;
    }

    public LocalDateTime getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDateTime enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", strudent_id=" + strudent_id +
                ", course_id=" + course_id +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}
