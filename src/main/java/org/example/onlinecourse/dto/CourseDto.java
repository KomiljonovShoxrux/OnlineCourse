package org.example.onlinecourse.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import org.example.onlinecourse.model.Instructor;

public class CourseDto {


    @Column(nullable = false)
    private String kursnomi;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String kursdavomiyligi;
    @ManyToOne
    private Long instructor_id;

    public CourseDto(String kursnomi, String description, String kursdavomiyligi, Long instructor_id) {
        this.kursnomi = kursnomi;
        this.description = description;
        this.kursdavomiyligi = kursdavomiyligi;
        this.instructor_id = instructor_id;
    }

    public CourseDto() {
    }

    public String getKursnomi() {
        return kursnomi;
    }

    public void setKursnomi(String kursnomi) {
        this.kursnomi = kursnomi;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKursdavomiyligi() {
        return kursdavomiyligi;
    }

    public void setKursdavomiyligi(String kursdavomiyligi) {
        this.kursdavomiyligi = kursdavomiyligi;
    }

    public Long getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(Long instructor_id) {
        this.instructor_id = instructor_id;
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "kursnomi='" + kursnomi + '\'' +
                ", description='" + description + '\'' +
                ", kursdavomiyligi='" + kursdavomiyligi + '\'' +
                ", instructor_id=" + instructor_id +
                '}';
    }
}
