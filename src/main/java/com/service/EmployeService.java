package com.service;


import com.dto.EmployeDTO;

import java.util.List;

public interface EmployeService {

    void save(EmployeDTO employeDTO);
    void delete(EmployeDTO employeDTO);
    List<EmployeDTO> getAll();
    EmployeDTO getById(int id);
}
