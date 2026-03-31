package com.medicalmanagement.controller;

import com.medicalmanagement.model.Appointment;
import com.medicalmanagement.model.Doctor;
import com.medicalmanagement.model.Patient;
import com.medicalmanagement.service.AppointmentService;
import com.medicalmanagement.service.DoctorService;
import com.medicalmanagement.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final DoctorService doctorService;

    public AppointmentController(AppointmentService appointmentService,
                                 PatientService patientService,
                                 DoctorService doctorService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    // ✅ Liste
    @GetMapping
    public List<Appointment> getAll() {
        return appointmentService.findAll();
    }

    // ✅ Tek kayıt
    @GetMapping("/{id}")
    public Appointment getById(@PathVariable Long id) {
        return appointmentService.findById(id).orElseThrow();
    }

    // ✅ Ekle (patientId ve doctorId ile)
    @PostMapping
    public Appointment create(@RequestParam Long patientId,
                              @RequestParam Long doctorId,
                              @RequestBody Appointment appointment) {

        Patient patient = patientService.findById(patientId).orElseThrow();
        Doctor doctor = doctorService.findById(doctorId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return appointmentService.save(appointment);
    }

    // ✅ Güncelle
    @PutMapping("/{id}")
    public Appointment update(@PathVariable Long id,
                              @RequestParam Long patientId,
                              @RequestParam Long doctorId,
                              @RequestBody Appointment appointment) {

        appointmentService.findById(id).orElseThrow(); // var mı kontrol

        Patient patient = patientService.findById(patientId).orElseThrow();
        Doctor doctor = doctorService.findById(doctorId).orElseThrow();

        appointment.setId(id);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return appointmentService.save(appointment);
    }

    // ✅ Sil
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        appointmentService.deleteById(id);
    }
}