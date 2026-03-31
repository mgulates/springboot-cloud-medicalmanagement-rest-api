package com.medicalmanagement.repository;

import com.medicalmanagement.model.Appointment;
import com.medicalmanagement.model.Doctor;
import com.medicalmanagement.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatient(Patient patient);
    List<Appointment> findByDoctor(Doctor doctor);
}