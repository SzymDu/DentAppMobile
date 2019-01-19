package com.example.szymon.dentapp.model;

import java.io.Serializable;
import java.util.Date;

public class Appointment implements Serializable {
    private Integer idappointment;

    private Date date;
    private String time;
    private Doctor doctorIddoctor;
    private Location locationIdlocation;
    private Patient patientIdpatient;
    private String description;

    public Integer getIdappointment() {
        return idappointment;
    }

    public void setIdappointment(Integer idappointment) {
        this.idappointment = idappointment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Doctor getDoctorIddoctor() {
        return doctorIddoctor;
    }

    public void setDoctorIddoctor(Doctor doctorIddoctor) {
        this.doctorIddoctor = doctorIddoctor;
    }

    public Location getLocationIdlocation() {
        return locationIdlocation;
    }

    public void setLocationIdlocation(Location locationIdlocation) {
        this.locationIdlocation = locationIdlocation;
    }

    public Patient getPatientIdpatient() {
        return patientIdpatient;
    }

    public void setPatientIdpatient(Patient patientIdpatient) {
        this.patientIdpatient = patientIdpatient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
