package com.prod_ready_feature.prod_ready_feeature.client.impl;

import com.prod_ready_feature.prod_ready_feeature.advice.ApiResponse;
import com.prod_ready_feature.prod_ready_feeature.client.EmployeeClient;
import com.prod_ready_feature.prod_ready_feeature.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        try{
            ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient.get().uri("employees").retrieve().body(new ParameterizedTypeReference<>() {});
            return employeeDTOList.getData();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
