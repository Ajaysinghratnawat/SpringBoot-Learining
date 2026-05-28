package com.ajay.JPATuts;

import com.ajay.JPATuts.entities.Product;
import com.ajay.JPATuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class JpaTutsApplicationTests {
	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		Product product = Product.builder().sku("nestle").title("choco").price(BigDecimal.valueOf(123.33)).quntity(12).build();
		Product save = productRepository.save(product);
		System.out.println(save);
	}
}
