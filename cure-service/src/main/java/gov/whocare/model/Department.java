package gov.whocare.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


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
    private List<Doctor> doctors;

    //bi-directional many-to-one association to Patient
    @OneToMany(mappedBy = "department")
    private List<Patient> patients;

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

    public List<Doctor> getDoctors() {
        return this.doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Doctor addDoctor(Doctor doctor) {
        getDoctors().add(doctor);
        doctor.setDepartment(this);

        return doctor;
    }

    public Doctor removeDoctor(Doctor doctor) {
        getDoctors().remove(doctor);
        doctor.setDepartment(null);

        return doctor;
    }

    public List<Patient> getPatients() {
        return this.patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public Patient addPatient(Patient patient) {
        getPatients().add(patient);
        patient.setDepartment(this);

        return patient;
    }

    public Patient removePatient(Patient patient) {
        getPatients().remove(patient);
        patient.setDepartment(null);

        return patient;
    }

}