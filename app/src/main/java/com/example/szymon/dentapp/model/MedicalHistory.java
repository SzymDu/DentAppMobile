package com.example.szymon.dentapp.model;

import java.io.Serializable;

public class MedicalHistory implements Serializable {
    public Integer getIdmedicalhistory() {
        return idmedicalhistory;
    }

    public void setIdmedicalhistory(Integer idmedicalhistory) {
        this.idmedicalhistory = idmedicalhistory;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getDiesese() {
        return diesese;
    }

    public void setDiesese(String diesese) {
        this.diesese = diesese;
    }

    public String getPregnant() {
        return pregnant;
    }

    public void setPregnant(String pregnant) {
        this.pregnant = pregnant;
    }

    public String getPregnantWeek() {
        return pregnantWeek;
    }

    public void setPregnantWeek(String pregnantWeek) {
        this.pregnantWeek = pregnantWeek;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Patient getPatientIdpatient() {
        return patientIdpatient;
    }

    public void setPatientIdpatient(Patient patientIdpatient) {
        this.patientIdpatient = patientIdpatient;
    }

    private Integer idmedicalhistory;
    private String allergy;
    private String diesese;
    private String pregnant;
    private String pregnantWeek;
    private String prescription;
    private String description;
    private Patient patientIdpatient;
}
