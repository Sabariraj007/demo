package com.example.demo.Entity;

import jakarta.persistence.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;


@Entity
@Table(name = "patients")
@RedisHash("Patient")
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Patient(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

    // Getters and Setters
}
