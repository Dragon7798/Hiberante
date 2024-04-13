package com.example.hibernate.repo;

import com.example.hibernate.entity.Author;
import com.example.hibernate.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
