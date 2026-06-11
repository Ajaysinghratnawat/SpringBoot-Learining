package com.prod_ready_feature.prod_ready_feeature.client;

import com.prod_ready_feature.prod_ready_feeature.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {
    List<EmployeeDTO> getAllEmployees();
}
