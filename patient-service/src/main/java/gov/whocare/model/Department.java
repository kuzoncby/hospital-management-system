package gov.whocare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the department database table.
 */
@Entity
@Table(name = "department")
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    //bi-directional many-to-one association to Doctor
    @OneToMany(mappedBy = "department")
    private Set<Doctor> doctors;

    //bi-directional many-to-one association to Patient
    @OneToMany(mappedBy = "department")
    private Set<Patient> patients;

    public Department() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public Set<Doctor> getDoctors() {
        return this.doctors;
    }

    @JsonIgnore
    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    @JsonIgnore
    public Doctor addDoctor(Doctor doctor) {
        getDoctors().add(doctor);
        doctor.setDepartment(this);

        return doctor;
    }

    @JsonIgnore
    public Doctor removeDoctor(Doctor doctor) {
        getDoctors().remove(doctor);
        doctor.setDepartment(null);

        return doctor;
    }

    @JsonIgnore
    public Set<Patient> getPatients() {
        return this.patients;
    }

    @JsonIgnore
    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    @JsonIgnore
    public Patient addPatient(Patient patient) {
        getPatients().add(patient);
        patient.setDepartment(this);

        return patient;
    }

    @JsonIgnore
    public Patient removePatient(Patient patient) {
        getPatients().remove(patient);
        patient.setDepartment(null);

        return patient;
    }

}