package com.service.impl;

import com.dao.EmployeDAO;
import com.entity.Employe;
import com.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class EmployeServiceImpl implements EmployeService {
    @Autowired
    private EmployeDAO dao;


    @Override
    @Transactional
    public void save(Employe employe) {
        this.dao.saveOrUpdate(employe);
    }

    @Override
    @Transactional
    public void delete(Employe employe) {
        this.dao.delete(employe);
    }

    @Override
    public List<Employe> getAll() {
        return this.dao.getAll();
    }

    @Override
    public Employe getById(int id) {
        return dao.getById(id);
    }
}
