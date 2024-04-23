package com.service;

import com.dto.EntrepriseDTO;

import java.util.List;

public interface EntrepriseService {

    void save(EntrepriseDTO entrepriseDTO);
    void delete(EntrepriseDTO entrepriseDTO);
    List<EntrepriseDTO> getAll();
    EntrepriseDTO getById(int id);

}
