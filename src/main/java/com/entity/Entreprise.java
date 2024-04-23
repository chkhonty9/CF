package com.entity;

import javax.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Entreprise {
    private Integer id;
    private String nom;
    private String ville;
    private String tel;
    private Collection<Employe> employes;

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
    @Column(name = "ville", nullable = false, length = 255)
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Basic
    @Column(name = "tel", nullable = false, length = 20)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entreprise that = (Entreprise) o;
        return Objects.equals(id, that.id) && Objects.equals(nom, that.nom) && Objects.equals(ville, that.ville) && Objects.equals(tel, that.tel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, ville, tel);
    }

    @OneToMany(mappedBy = "entreprise")
    public Collection<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(Collection<Employe> employesById) {
        this.employes = employesById;
    }
}
