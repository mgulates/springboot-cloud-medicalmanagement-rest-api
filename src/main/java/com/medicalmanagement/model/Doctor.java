package com.medicalmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16, nullable = false)
    private String name;

    @Column(length = 16, nullable = false)
    private String clinique;

    @Column(nullable = true)
    private String profileImage;

    public Doctor() {}

    public Doctor(Long id, String name, String clinique, String profileImage) {
        this.id = id;
        this.name = name;
        this.clinique = clinique;
        this.profileImage = profileImage;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getClinique() { return clinique; }
    public void setClinique(String clinique) { this.clinique = clinique; }

    public String getProfileImage() { return profileImage; }
    public void setProfileImage(String profileImage) { this.profileImage = profileImage; }
}