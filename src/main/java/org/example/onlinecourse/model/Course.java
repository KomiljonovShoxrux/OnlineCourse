package org.example.onlinecourse.model;

import jakarta.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String kursnomi;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String kursdavomiyligi;
    @ManyToOne
    private Instructor instructor_id;

    public Course(Long id, String kursnomi, String description, String kursdavomiyligi, Instructor instructor_id) {
        this.id = id;
        this.kursnomi = kursnomi;
        this.description = description;
        this.kursdavomiyligi = kursdavomiyligi;
        this.instructor_id = instructor_id;
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Instructor getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(Instructor instructor_id) {
        this.instructor_id = instructor_id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", kursnomi='" + kursnomi + '\'' +
                ", description='" + description + '\'' +
                ", kursdavomiyligi='" + kursdavomiyligi + '\'' +
                ", instructor_id=" + instructor_id +
                '}';
    }
}
