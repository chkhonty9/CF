package com.bean;

import com.entity.Entreprise;
import com.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import java.util.List;

@Component
@ManagedBean
@Scope("session")
public class EntrepriseBean {
    @Autowired
    private EntrepriseService service;

    private Entreprise entreprise;
    private boolean modifyContext;

    public EntrepriseBean() {
        this.entreprise = new Entreprise();
        this.modifyContext = false;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public boolean isModifyContext() {
        return modifyContext;
    }

    public void setModifyContext(boolean modifyContext) {
        this.modifyContext = modifyContext;
    }

    public String getLabel() {
        return isModifyContext() ? "Modification" : "Ajout";
    }

    public List<Entreprise> getEntreprises(){
        return this.service.getAll();
    }

    @Transactional
    public void save(){
        this.service.save(this.entreprise);
        this.setModifyContext(false);
        this.setEntreprise(new Entreprise());
    }

    public void modifier(Entreprise e) {

        this.setModifyContext(true);
        this.setEntreprise(e);
    }

    @Transactional
    public void delete(Entreprise e){
        this.service.delete(e);
    }

}
