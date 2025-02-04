package com.example.demo.Service;

import com.example.demo.Entity.Patient;
import com.example.demo.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

//    @Autowired
//    private RedisTemplate template;

    @Cacheable(value = "patients", key = "#id")
    public Optional<Patient> getPatientById(Long id) {
//        System.out.println("Fetching from database...");
        return patientRepository.findById(id);
    }
    @CachePut(value = "patients", key = "#patient.id")
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @CacheEvict(value = "patients", key = "#id")
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

}
