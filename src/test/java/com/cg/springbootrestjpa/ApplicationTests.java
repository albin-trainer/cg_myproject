package com.cg.springbootrestjpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
import com.cg.entity.Product;
import com.cg.repository.ProductRepository;
import com.cg.service.ProductService;
import com.cg.service.impl.ProductServiceImpl;

@SpringBootTest
class ApplicationTests {
	@InjectMocks
ProductServiceImpl service;
	@Mock //Mock obj not real
ProductRepository rep;	
	@Test
	void contextLoads() {
	}
	@Test
	void testProduct() {
		Product p1=new Product(101, "Boat earphones", 2000);
		//Pre Condition 
		Mockito.when(rep.findById(101)).thenReturn(Optional.of(p1));
		//here it wont access the DB
		Product p2=service.searchProductByCodeService(101);
		assertEquals(p1.getProductName(), p2.getProductName());
		//verify(rep,times(1)).findById(101);
	}
  @Test
	void testGetAllProducts() {
	  //Mock data
	  Product p1=new Product(101, "Boat earphones", 2000);
	  Product p2=new Product(102, "mobile", 10000);
	  Product p3=new Product(103, "laptop", 50000);
	  Product p4=new Product(104, "mouse", 2000);
	  List<Product> list=new ArrayList<Product>();
	  list.add(p1);  list.add(p2);  list.add(p3);  list.add(p4);
	   //Pre condition
	  Mockito.when(rep.findAll()).thenReturn(list);
	  //calling service class method
	  
	  List<Product> list2=service.allProductsService();
	  //comparing actual and expected 
	  assertEquals(list.size(), list2.size());
	}
}
