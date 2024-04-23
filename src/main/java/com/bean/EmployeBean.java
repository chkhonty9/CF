package com.bean;

import com.entity.Employe;
import com.service.EmployeService;
import com.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import java.util.List;

@Component
@ManagedBean
@Scope("session")
public class EmployeBean {

    @Autowired
    private EmployeService employeService;
    @Autowired
    private EntrepriseService entrepriseService;

    private Employe employe;
    private boolean modifyContext;

    private int entreprise;

    public EmployeBean() {
        this.employe = new Employe();
        this.modifyContext = false;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
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

    public List<Employe> getEmployes(){
        return this.employeService.getAll();
    }


    public int getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(int entreprise) {
        this.entreprise = entreprise;
    }

    public void save(){
        this.employe.setEntreprise(entrepriseService.getById(entreprise));

        System.out.println("salaire : "+employe.getSalaire());
        this.employeService.save(this.employe);
        this.setEmploye(new Employe());
        this.setModifyContext(false);
    }

    public void modifier(Employe e){
        this.setEmploye(e);
        this.setModifyContext(true);
    }

    public void supp(Employe e){
        this.employeService.delete(e);
    }
}
