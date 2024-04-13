package com.example.hibernate.service;

import com.example.hibernate.entity.*;
import com.example.hibernate.repo.AddressRepo;
import com.example.hibernate.repo.AuthorRepo;
import com.example.hibernate.repo.CourseRepo;
import com.example.hibernate.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DbOperations {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    AuthorRepo authorRepo;

    @Autowired
    CourseRepo courseRepo;


    /**
     * --   Many To Many & Many To One   --
     **/
    public Student insert() {
        Student student = new Student();

        student.setId(3 );
        student.setName("Zatu");

        Address address = new Address();

        address.setId(student.getId());
        address.setCity("kwk");
        address.setPincode(416602);
        address.setStreet("N H H H");

        student.setAddress(address);
        address.setStudent(student);

        Teacher teacher = new Teacher();
        teacher.setName("abc");
        teacher.setSubject("History");

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(student);
        teacher.setStudents(studentSet);

        Set<Teacher> teachers = new HashSet<>();
        teachers.add(teacher);

        student.setTeachers(teachers);

        Course course = new Course();

        course.setName("New");
        courseRepo.save(course);

        student.setCourse(course);

        return studentRepo.save(student);
    }

    public Address saveAddress(Address address) {

        return addressRepo.save(address);
    }



    /** --  One To Many  -- **/
    public Author oneToMany(Author author) {

        Author author1 = new Author();
        Book book = new Book();

        author1.setId(author.getId());
        author1.setName(author.getName());

        book.setAuthor(author1);

        book.setName(author.getBookList().get(0).getName());
        book.setYear(author.getBookList().get(0).getYear());
        book.setId(author.getBookList().get(0).getId());

        author1.setBookList(Collections.singletonList(book));


        return authorRepo.save(author1);
    }

    public List<Map<String, Object>> fetch(){
        return studentRepo.fetch();
    }
}
