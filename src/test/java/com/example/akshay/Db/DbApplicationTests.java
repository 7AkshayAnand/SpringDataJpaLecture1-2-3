package com.example.akshay.Db;

import com.example.akshay.Db.entities.ProductEntity;
import com.example.akshay.Db.repository.ProductRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DbApplicationTests {
 @Autowired
 ProductRepository productRepository;
	@Test
	void contextLoads() {
	}
	@Test
	@Order(1)
	void testRepository(){
		ProductEntity productEntity=ProductEntity.builder().sku("nestle").title("nestle chocolates").price(BigDecimal.valueOf(23.45)).quantity(4).build();

		ProductEntity savedProductEntity=  productRepository.save(productEntity);
		System.out.println(savedProductEntity);
	}

//	@Test
//	void getRepository(){
//		List<ProductEntity> entities=productRepository.findAll();
//		System.out.println(entities);
//
//	}
//	@Test
//	void getByTitle(){
//		List<ProductEntity> entities=productRepository.findByTitle("Pepsi");
//		System.out.println("the output is "+entities);
//
//	}
//	@Test
//	void getCreatedAfter(){
//		List<ProductEntity> entities=productRepository.findByCreatedAtAfter(LocalDateTime.of(2024,1,1,0,0,0));
//		System.out.println("the output is "+entities);
//
//	}

//	@Test
//	@Order(2)
//	void getQtyPrc(){
//		List<ProductEntity> entities=productRepository.findByQuantityAndPrice(4,BigDecimal.valueOf(23.45));
//		System.out.println("the output is "+entities);
//	}
//	@Test
//	@Order(2)
//	void getQtyPrcOnCond(){
//		List<ProductEntity> entities=productRepository.findByQuantityGreaterThanAndPriceLessThan(4,BigDecimal.valueOf(23.45));
//		System.out.println("the output is "+entities);
//	}
//	@Test
//	@Order(2)
//	void getTitleLike(){
//		List<ProductEntity> entities=productRepository.findByTitleLike("%A%");
//		System.out.println("the output is "+entities);
//	}

	@Test
	void getTitlePrice(){
		Optional<ProductEntity> entities=productRepository.findByTitleAndPrice("MAZA",BigDecimal.valueOf(16.40));
		System.out.println("the output is "+entities);
	}

}
