package gov.whocare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the patient database table.
 */
@Entity
@Table(name = "patient")
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private String name;

    //bi-directional many-to-one association to Cure
    @OneToMany(mappedBy = "patient")
    @JsonManagedReference
    private Set<Cure> cures;

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
    private Set<Doctor> doctors;

    //bi-directional many-to-one association to Department
    @ManyToOne
    private Department department;

    public Patient() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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

    @JsonIgnore
    public Set<Cure> getCures() {
        return this.cures;
    }

    @JsonIgnore
    public void setCures(Set<Cure> cures) {
        this.cures = cures;
    }

    @JsonIgnore
    public Cure addCure(Cure cure) {
        getCures().add(cure);
        cure.setPatient(this);

        return cure;
    }

    @JsonIgnore
    public Cure removeCure(Cure cure) {
        getCures().remove(cure);
        cure.setPatient(null);

        return cure;
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
    public Department getDepartment() {
        return this.department;
    }

    @JsonIgnore
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", cures=" + cures +
                ", doctors=" + doctors +
                ", department=" + department +
                '}';
    }
}