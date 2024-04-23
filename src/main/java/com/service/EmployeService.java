package com.service;


import com.entity.Employe;

import java.util.List;

public interface EmployeService {

    void save(Employe employe);
    void delete(Employe employe);
    List<Employe> getAll();
    Employe getById(int id);
}
