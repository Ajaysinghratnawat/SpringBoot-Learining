package com.prod_ready_feature.prod_ready_feeature;

import com.prod_ready_feature.prod_ready_feeature.client.EmployeeClient;
import com.prod_ready_feature.prod_ready_feeature.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProdReadyFeeatureApplicationTests {

	@Autowired
	EmployeeClient employeeClient;

	@Test
	void getAllEmployees() {
		List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployees();
		System.out.println(employeeDTOList);
	}

}
