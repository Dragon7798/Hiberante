package com.example.hibernate.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Student")
public class Student {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_teacher", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private Set<Teacher> teachers;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
