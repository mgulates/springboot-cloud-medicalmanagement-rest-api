package com.medicalmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16, nullable = false)
    private String name;

    @Column(length = 32, nullable = false)
    private String address;

    @Column(length = 16, nullable = false)
    private String telephone;

    @Column(nullable = true)
    private String profileImage;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Patient() {}

    public Patient(Long id, String name, String address, String telephone, String profileImage, User user) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.profileImage = profileImage;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}