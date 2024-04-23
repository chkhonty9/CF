package com.service.impl;

import com.dao.EntrepriseDAO;
import com.dto.EntrepriseDTO;
import com.mapper.EntrepriseMapper;
import com.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntrepriseServiceImpl implements EntrepriseService {

    @Autowired
    private EntrepriseDAO dao;

    @Autowired
    private EntrepriseMapper mapper;

    @Override
    @Transactional
    public void save(EntrepriseDTO entrepriseDTO) {
        this.dao.saveOrUpdate(mapper.fromEntrepriseDTO(entrepriseDTO));
    }

    @Override
    @Transactional
    public void delete(EntrepriseDTO entrepriseDTO) {
        this.dao.delete(mapper.fromEntrepriseDTO(entrepriseDTO));
    }

    @Override
    public List<EntrepriseDTO> getAll() {
        return this.dao.getAll().stream().map(e -> mapper.fromEntreprise(e)).collect(Collectors.toList());
    }

    @Override
    public EntrepriseDTO getById(int id) {
        return mapper.fromEntreprise(dao.getById(id));
    }
}
