package gov.whocare.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the patient database table.
 */
@Entity
@Table(name = "patient")
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;

    private String name;

    //bi-directional many-to-one association to Cure
    @OneToMany(mappedBy = "patient")
    private List<Cure> cures;

    //bi-directional many-to-many association to Doctor
    @ManyToMany
    @JoinTable(
            name = "doctor_has_patient"
            , joinColumns = {
            @JoinColumn(name = "patient_id")
    }
            , inverseJoinColumns = {
            @JoinColumn(name = "doctor_id")
    }
    )
    private List<Doctor> doctors;

    //bi-directional many-to-one association to Department
    @ManyToOne
    private Department department;

    public Patient() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cure> getCures() {
        return this.cures;
    }

    public void setCures(List<Cure> cures) {
        this.cures = cures;
    }

    public Cure addCure(Cure cure) {
        getCures().add(cure);
        cure.setPatient(this);

        return cure;
    }

    public Cure removeCure(Cure cure) {
        getCures().remove(cure);
        cure.setPatient(null);

        return cure;
    }

    public List<Doctor> getDoctors() {
        return this.doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}