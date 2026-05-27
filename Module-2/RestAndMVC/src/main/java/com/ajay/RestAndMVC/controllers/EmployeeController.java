package com.ajay.RestAndMVC.controllers;

import com.ajay.RestAndMVC.dto.EmployeeDTO;
import com.ajay.RestAndMVC.entities.EmployeeEntity;
import com.ajay.RestAndMVC.repositories.EmployeeRepository;
import com.ajay.RestAndMVC.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //PathVariable
    //ResponseEntity
    @GetMapping(path = "/{employeeID}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long employeeID){
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(employeeID);
//        if(employeeDTO==null) return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(employeeDTO);
        return employeeDTO.map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1)).orElse(ResponseEntity.notFound().build());
    }

    //RequestParams
    @GetMapping(path = "")
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age){
        return employeeService.findAll();
    }

    @PostMapping("/post")
    public EmployeeDTO createNewEmployee(@RequestBody @Valid EmployeeDTO employee){
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
