package com.example.hibernate.repo;

import com.example.hibernate.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    @Transactional
    @Procedure("select_and_return")
    List<Map<String, Object>> fetch();
}
