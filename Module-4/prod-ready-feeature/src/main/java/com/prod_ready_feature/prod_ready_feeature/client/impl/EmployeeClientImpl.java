package com.prod_ready_feature.prod_ready_feeature.client.impl;

import com.prod_ready_feature.prod_ready_feeature.advice.ApiResponse;
import com.prod_ready_feature.prod_ready_feeature.client.EmployeeClient;
import com.prod_ready_feature.prod_ready_feeature.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    Logger log = LoggerFactory.getLogger(EmployeeClientImpl.class);

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        log.error("error log");
        log.warn("warn log");
        log.info("info log");
        log.debug("debug log");
        log.trace("trace log");
        try{
            ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient.get().uri("employees").retrieve().body(new ParameterizedTypeReference<>() {});
            return employeeDTOList.getData();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
