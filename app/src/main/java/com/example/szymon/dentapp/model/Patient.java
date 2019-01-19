package com.example.szymon.dentapp.model;

import java.io.Serializable;
import java.util.Collection;

public class Patient  implements Serializable {

    private Integer idpatient;
    private String name;
    private String surname;
    private String dateOfBirth;
    private String phoneNumber;
    private String email;
    private String password;
    private String pesel;
    private Collection<MedicalHistory> medicalhistoryCollection;
    private Collection<Appointment> appointmentCollection;

    public Integer getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(Integer idpatient) {
        this.idpatient = idpatient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Collection<MedicalHistory> getMedicalhistoryCollection() {
        return medicalhistoryCollection;
    }

    public void setMedicalhistoryCollection(Collection<MedicalHistory> medicalhistoryCollection) {
        this.medicalhistoryCollection = medicalhistoryCollection;
    }

    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }
}
