package com.ajay.Testing.services.impl;

import com.ajay.Testing.dto.EmployeeDto;
import com.ajay.Testing.entities.Employee;
import com.ajay.Testing.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void testGetEmployeeById_WhenEmployeeIdIsPresent_ThenReturnEmployeeDto() {
//        Assign
        Long id = 1L;
        Employee mockEmployee = Employee.builder()
                .id(id).email("ajay@gmail.com")
                .name("Ajay")
                .salary(200L)
                .build();
        when(employeeRepository.findById(id)).thenReturn(Optional.of(mockEmployee));//stubing
//        Act
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
//        Assert
        assertThat(employeeDto.getId()).isEqualTo(id);
        assertThat(employeeDto.getEmail()).isEqualTo(mockEmployee.getEmail());
        verify(employeeRepository).findById(id);
//        ArgumentCaptor<Employee> employeeArgumentCaptor = ArgumentCaptor.forClass(Employee.class);
//        verify(employeeRepository).findById(employeeArgumentCaptor.capture().getId());
    }
}