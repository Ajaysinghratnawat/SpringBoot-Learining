package com.ajay.JPATuts;

import com.ajay.JPATuts.entities.Product;
import com.ajay.JPATuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutsApplicationTests {
	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		Product product = Product.builder().sku("nestle").title("choco").price(BigDecimal.valueOf(123.33)).quantity(12).build();
		Product save = productRepository.save(product);
		System.out.println(save);
	}

	@Test
	void getRepository() {
//		List<Product> entities = productRepository.findByCreatedAtAfter(
//				LocalDateTime.of(2025, 1, 1, 0, 0, 0 ));
//		List<Product> entities = productRepository.findByQuantityGreaterThanOrPriceLessThan(4, BigDecimal.valueOf(23.45));
		List<Product> entities = productRepository.findByTitleContainingIgnoreCase("CHOco", null);
		System.out.println(entities);
	}

	@Test
	void getSingleFromRepository() {
		Optional<Product> productEntity = productRepository
				.findByTitleAndPrice("Peps", BigDecimal.valueOf(14.4));
		productEntity.ifPresent(System.out::println);
	}

}
