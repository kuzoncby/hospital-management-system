package gov.whocare.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medical database table.
 */
@Entity
@Table(name = "medical")
public class Medical implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    //bi-directional many-to-one association to Cure
    @OneToMany(mappedBy = "medical")
    private List<Cure> cures;

    public Medical() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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
        cure.setMedical(this);

        return cure;
    }

    public Cure removeCure(Cure cure) {
        getCures().remove(cure);
        cure.setMedical(null);

        return cure;
    }

}