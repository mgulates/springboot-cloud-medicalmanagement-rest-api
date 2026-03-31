package com.medicalmanagement.repository;

import com.medicalmanagement.model.Doctor;
import com.medicalmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    long count();  // Bu metod zaten mevcut, eklemeye gerek yok
    Optional<Doctor> findByName(String username);
}
