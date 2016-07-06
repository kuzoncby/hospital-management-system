package gov.whocare.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the cure database table.
 */
@Entity
@Table(name = "cure")
public class Cure implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double count;

    private Timestamp date;

    private String unit;

    //bi-directional many-to-one association to Doctor
    @ManyToOne
    private Doctor doctor;

    //bi-directional many-to-one association to Medical
    @ManyToOne
    private Medical medical;

    //bi-directional many-to-one association to Patient
    @ManyToOne
    @JsonBackReference
    private Patient patient;

    public Cure() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCount() {
        return this.count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public Timestamp getDate() {
        return this.date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @JsonIgnore
    public Doctor getDoctor() {
        return this.doctor;
    }

    @JsonIgnore
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @JsonIgnore
    public Medical getMedical() {
        return this.medical;
    }

    @JsonIgnore
    public void setMedical(Medical medical) {
        this.medical = medical;
    }

    @JsonIgnore
    public Patient getPatient() {
        return this.patient;
    }

    @JsonIgnore
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}