package com.service.impl;

import com.dao.EntrepriseDAO;
import com.entity.Entreprise;
import com.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class EntrepriseServiceImpl implements EntrepriseService {

    @Autowired
    private EntrepriseDAO dao;


    @Override
    @Transactional
    public void save(Entreprise entreprise) {
        this.dao.saveOrUpdate(entreprise);
    }

    @Override
    @Transactional
    public void delete(Entreprise entreprise) {
        this.dao.delete(entreprise);
    }

    @Override
    public List<Entreprise> getAll() {
        return this.dao.getAll();
    }

    @Override
    public Entreprise getById(int id) {
        return dao.getById(id);
    }
}
