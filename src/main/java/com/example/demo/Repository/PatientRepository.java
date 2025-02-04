package com.example.demo.Repository;  // Make sure this matches the package name

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
