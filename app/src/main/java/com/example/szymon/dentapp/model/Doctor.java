package com.example.szymon.dentapp.model;

import java.io.Serializable;
import java.util.Collection;

public class Doctor implements Serializable {

    private Integer iddoctor;
    private String name;

    private String surname;

    private String dateOfBirth;

    private String email;

    private String pesel;

    private String password;

    private String phoneNumber;

    private Collection<Appointment> appointmentCollection;
    private Location location;

    public Integer getIddoctor() {
        return iddoctor;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getPesel() {
        return pesel;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public Location getLocation() {
        return location;
    }

    public void setIddoctor(Integer iddoctor) {
        this.iddoctor = iddoctor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


}
