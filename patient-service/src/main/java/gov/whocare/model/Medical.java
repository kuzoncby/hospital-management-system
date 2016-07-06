package gov.whocare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the medical database table.
 */
@Entity
@Table(name = "medical")
public class Medical implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    //bi-directional many-to-one association to Cure
    @OneToMany(mappedBy = "medical")
    private Set<Cure> cures;

    public Medical() {
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
        cure.setMedical(this);

        return cure;
    }

    @JsonIgnore
    public Cure removeCure(Cure cure) {
        getCures().remove(cure);
        cure.setMedical(null);

        return cure;
    }

}