package com.medicalmanagement.repository;

import com.medicalmanagement.model.Patient;
import com.medicalmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByName(String name);
}