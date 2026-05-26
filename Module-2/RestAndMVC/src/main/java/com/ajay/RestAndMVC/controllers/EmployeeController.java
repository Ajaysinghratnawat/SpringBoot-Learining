package com.ajay.RestAndMVC.controllers;

import com.ajay.RestAndMVC.dto.EmployeeDTO;
import com.ajay.RestAndMVC.entities.EmployeeEntity;
import com.ajay.RestAndMVC.repositories.EmployeeRepository;
import com.ajay.RestAndMVC.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //PathVariable
    @GetMapping(path = "/{employeeID}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeID){
        return employeeService.getEmployeeById(employeeID);
    }

    //RequestParams
    @GetMapping(path = "")
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age){
        return employeeService.findAll();
    }

    @PostMapping("/post")
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employee){
        return employeeService.createNewEmployee(employee);
    }

    @PutMapping(path = "/{employeeId}")
    public EmployeeDTO updateEmployeeById(@RequestBody EmployeeDTO employeeDTO,@PathVariable Long employeeId){
        return employeeService.updateEmployeeById(employeeId,employeeDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
    }

//    @PatchMapping(path = "/{employeeId}")
//    public EmployeeDTO updatePartialEmployeeById(@RequestBody Map<String,Object> updates, @PathVariable Long employeeId){
//        return employeeService.updatePartialEmployeeById(employeeId,updates);
//    }

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
