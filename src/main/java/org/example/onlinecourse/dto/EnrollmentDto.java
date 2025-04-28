package org.example.onlinecourse.dto;

import jakarta.persistence.ManyToOne;
import org.example.onlinecourse.model.Course;
import org.example.onlinecourse.model.Strudent;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

public class EnrollmentDto {


    @ManyToOne
    private Long strudent_id;
    @ManyToOne
    private Long course_id;
    @CreatedDate
    private LocalDateTime enrollmentDate;

    public EnrollmentDto(Long strudent_id, Long course_id, LocalDateTime enrollmentDate) {
        this.strudent_id = strudent_id;
        this.course_id = course_id;
        this.enrollmentDate = enrollmentDate;
    }

    public EnrollmentDto() {
    }

    public Long getStrudent_id() {
        return strudent_id;
    }

    public void setStrudent_id(Long strudent_id) {
        this.strudent_id = strudent_id;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
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
        return "EnrollmentDto{" +
                "strudent_id=" + strudent_id +
                ", course_id=" + course_id +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}
