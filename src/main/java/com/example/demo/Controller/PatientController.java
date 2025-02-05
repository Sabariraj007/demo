package com.example.demo.Controller;

import com.example.demo.Entity.Patient;
import com.example.demo.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/{id}")
//    @Cacheable(value = "patients", key = "#id")
    public Optional<Patient> getPatientById(@PathVariable Long id) {
        System.out.println("Fetching from database...");
          return patientService.getPatientById(id);
    }
    @PostMapping()
//    @CachePut(value = "patients", key = "#patient.id")
    public Patient updatePatient( @RequestBody Patient patient) {
        Patient p=patientService.updatePatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(p).getBody();
    }
    @DeleteMapping
//    @CacheEvict(value = "patients", key = "#id")
    public ResponseEntity<Object> deletePatient(Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping
    dslsd
}
