package com.ajay.RestAndMVC.service;

import com.ajay.RestAndMVC.dto.EmployeeDTO;
import com.ajay.RestAndMVC.entities.EmployeeEntity;
import com.ajay.RestAndMVC.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id){
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        return employeeEntity.map(employeeEntity1 -> mapper.map(employeeEntity1,EmployeeDTO.class));
    }

    public List<EmployeeDTO> findAll(){
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities.stream().map(employeeEntity -> mapper.map(employeeEntity,EmployeeDTO.class)).collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employee){
        EmployeeEntity toSaveEntity = mapper.map(employee,EmployeeEntity.class);
        EmployeeEntity employeeEntity = employeeRepository.save(toSaveEntity);
        return mapper.map(employeeEntity,EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(Long id,EmployeeDTO employeeDTO){
        EmployeeEntity employeeEntity = mapper.map(employeeDTO,EmployeeEntity.class);
        employeeEntity.setId(id);
        EmployeeEntity saveEmployeeEntity = employeeRepository.save(employeeEntity);
        return mapper.map(saveEmployeeEntity,EmployeeDTO.class);
    }

    public void deleteEmployeeById(Long id){
        boolean exists = employeeRepository.existsById(id);
        if (exists) employeeRepository.deleteById(id);
    }

}
