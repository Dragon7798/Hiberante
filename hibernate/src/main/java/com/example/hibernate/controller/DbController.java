package com.example.hibernate.controller;

import com.example.hibernate.entity.Address;
import com.example.hibernate.entity.Author;
import com.example.hibernate.entity.Student;
import com.example.hibernate.service.DbOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DbController {

    @Autowired
    DbOperations operations;

    @GetMapping("/get")
    public Student save() {
        return operations.insert();
    }

    @PostMapping("/post")
    public Address save(@RequestBody Address address){
       return    operations.saveAddress(address);
    }


    @PostMapping("/author")
    public Author saveAuthor(@RequestBody Author author){
        return  operations.oneToMany(author);
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<Map<String , Object>>> fetch(){
        return new ResponseEntity<>(operations.fetch() , HttpStatus.OK );

    }
}
