package com.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Employe {
    private Integer id;
    private String nom;
    private String tel;
    private BigDecimal salaire;
    private Entreprise entreprise;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 255)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "tel", nullable = false, length = 20)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "salaire", nullable = false, precision = 5)
    public BigDecimal getSalaire() {
        return salaire;
    }

    public void setSalaire(BigDecimal salaire) {
        this.salaire = salaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return Objects.equals(id, employe.id) && Objects.equals(nom, employe.nom) && Objects.equals(tel, employe.tel) && Objects.equals(salaire, employe.salaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, tel, salaire);
    }

    @ManyToOne
    @JoinColumn(name = "entreprise", referencedColumnName = "id", nullable = false)
    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entrepriseByEntreprise) {
        this.entreprise = entrepriseByEntreprise;
    }
}
