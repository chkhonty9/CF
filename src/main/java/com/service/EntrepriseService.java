package com.service;


import com.entity.Entreprise;

import java.util.List;

public interface EntrepriseService {

    void save(Entreprise entreprise);
    void delete(Entreprise entreprise);
    List<Entreprise> getAll();
    Entreprise getById(int id);

}
