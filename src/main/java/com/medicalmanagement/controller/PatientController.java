package com.medicalmanagement.controller;

import com.medicalmanagement.model.Patient;
import com.medicalmanagement.service.PatientService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "*")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // ✅ Liste
    @GetMapping
    public List<Patient> getAll() {
        return patientService.findAll();
    }

    // ✅ Tek kayıt
    @GetMapping("/{id}")
    public Patient getById(@PathVariable Long id) {
        return patientService.findById(id).orElseThrow();
    }

    // ✅ Ekle (JSON)
    @PostMapping
    public Patient create(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    // ✅ Güncelle (JSON)
    @PutMapping("/{id}")
    public Patient update(@PathVariable Long id, @RequestBody Patient patient) {
        patientService.findById(id).orElseThrow();
        patient.setId(id);
        return patientService.save(patient);
    }

    // ✅ Sil
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        patientService.deleteById(id);
    }

    // ✅ Profil resmi yükle (isteğe bağlı endpoint)
    // Postman: form-data -> imageFile (type: File)
    @PostMapping(value = "/{id}/profile-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Patient uploadProfileImage(@PathVariable Long id,
                                      @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        Patient patient = patientService.findById(id).orElseThrow();

        if (imageFile != null && !imageFile.isEmpty()) {
            // Eğer image upload sistemin varsa burada entegre edersin.
            // Şimdilik sadece dosya adını kaydediyoruz gibi düşün:
            patient.setProfileImage(imageFile.getOriginalFilename());
        }

        return patientService.save(patient);
    }
}