package com.ajay.RestAndMVC.controllers;

import com.ajay.RestAndMVC.dto.EmployeeDTO;
import com.ajay.RestAndMVC.entities.EmployeeEntity;
import com.ajay.RestAndMVC.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //PathVariable
    @GetMapping(path = "/{employeeID}")
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeID){
        return employeeRepository.findById(employeeID).orElse(null);
    }

    //RequestParams
    @GetMapping(path = "")
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) Integer age){
        return employeeRepository.findAll();
    }

    @PostMapping("/post")
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employee){
        return employeeRepository.save(employee);
    }

    //    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage(){
//        return "Secret Message";
//    }

//    //PathVariable
//    @GetMapping(path = "/{employeeID}")
//    public EmployeeDTO getEmployeeById(@PathVariable Long employeeID){
//        return new EmployeeDTO(employeeID,"Ajay","ajay@gmail.com",21, LocalDate.of(2026,5,25),true);
//    }
//
//    //RequestParams
//    @GetMapping(path = "")
//    public String getAllEmployees(@RequestParam(required = false) Integer age){
//        return "hii age "+age;
//    }
//
//    @PostMapping
//    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employee){
//        employee.setId(100L);
//        return employee;
//    }
//
//    @PutMapping
//    public String updateEmployeeById(){
//        return "Hello from put";
//    }
}
