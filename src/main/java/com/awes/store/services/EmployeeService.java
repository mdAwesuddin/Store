package com.awes.store.services;

import com.awes.store.dto.EmployeeDTO;
import com.awes.store.entities.EmployeeEntity;
import com.awes.store.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;   // if we use autowired repository it will be added even if we don't use

    final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {  // if we use construtor it will be added when it will be needed
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.getById(id);
//        return new EmployeeDTO(employeeEntity.getId(), employeeEntity.getName(), employeeEntity.getDateOfJoining(), employeeEntity.isActive()); this can be done using modelMapper
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream().map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class)).collect(Collectors.toList());
    }


    public boolean deleteEmployeeById(Long id) {
        boolean isPresent = employeeRepository.existsById(id);
        if(!isPresent) return false;
        employeeRepository.deleteById(id);
        return true;
    }
}
