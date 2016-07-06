package gov.whocare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the doctor database table.
 */
@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String password;

    //bi-directional many-to-one association to Cure
    @OneToMany(mappedBy = "doctor")
    private Set<Cure> cures;

    //bi-directional many-to-one association to Department
    @ManyToOne
    private Department department;

    //bi-directional many-to-many association to Patient
    @ManyToMany(mappedBy = "doctors")
    private Set<Patient> patients;

    public Doctor() {
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        cure.setDoctor(this);

        return cure;
    }

    @JsonIgnore
    public Cure removeCure(Cure cure) {
        getCures().remove(cure);
        cure.setDoctor(null);

        return cure;
    }

    @JsonIgnore
    public Department getDepartment() {
        return this.department;
    }

    @JsonIgnore
    public void setDepartment(Department department) {
        this.department = department;
    }

    @JsonIgnore
    public Set<Patient> getPatients() {
        return this.patients;
    }

    @JsonIgnore
    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

}