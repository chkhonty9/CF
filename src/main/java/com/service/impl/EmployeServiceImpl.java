package com.service.impl;

import com.dao.EmployeDAO;
import com.dto.EmployeDTO;
import com.mapper.EmployeMapper;
import com.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeServiceImpl implements EmployeService {
    @Autowired
    private EmployeDAO dao;

    @Autowired
    private EmployeMapper mapper;

    @Override
    @Transactional
    public void save(EmployeDTO employeDTO) {
        this.dao.saveOrUpdate(mapper.fromEmployeDTO(employeDTO));
    }

    @Override
    @Transactional
    public void delete(EmployeDTO employeDTO) {
        this.dao.delete(mapper.fromEmployeDTO(employeDTO));
    }

    @Override
    public List<EmployeDTO> getAll() {
        return this.dao.getAll().stream().map(e -> mapper.fromEmploye(e)).collect(Collectors.toList());
    }

    @Override
    public EmployeDTO getById(int id) {
        return mapper.fromEmploye(dao.getById(id));
    }
}
