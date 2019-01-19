package com.example.szymon.dentapp.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class Location implements Serializable {

    public Integer getIdlocation() {
        return idlocation;
    }

    public void setIdlocation(Integer idlocation) {
        this.idlocation = idlocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    private Integer idlocation;
    private String name;
    private Long longitude;
    private Long latitude;
    private String address;
    private Collection<Appointment> appointmentCollection;
    private List<Doctor> doctors;
}
