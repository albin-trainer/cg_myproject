package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entity.Product;
import com.cg.service.ProductService;
@RestController
@RequestMapping("products")
public class ProductCatalogue {
	@Autowired
	private ProductService productService;
@RequestMapping("/test")
	public Product testApi() {
		Product p= new Product();
		p.setProductCode(101);
		p.setProductName("Laptop");
		p.setPrice(500000);
		return p;
	}
//@RequestMapping(method = RequestMethod.POST)
@PostMapping
public Product addNewProduct( @RequestBody  @Valid Product p) {
	
	return productService.addNewProductService(p);
}
//@RequestMapping(method = RequestMethod.GET )
@GetMapping
public  ResponseEntity<List<Product>> getAllProducts(){
	return   new  ResponseEntity<>( productService.allProductsService(), HttpStatus.OK);
}
//@RequestMapping("/{prodCode}") //default is GET
@GetMapping("/{prodCode}")
public Product searchById( @PathVariable("prodCode") int pcode) {
	return productService.searchProductByCodeService(pcode);
}
//@RequestMapping (value = "/{prodCode}",   method = RequestMethod.DELETE )
@DeleteMapping("/{prodCode}")
public String removeProduct(@PathVariable("prodCode") int prodCode){
	//return productService.allProductsService();
	return "";
}
//@RequestMapping (value = "/{prodCode}",   method = RequestMethod.PUT )
@PutMapping(value = "/{prodCode}")
public Product updateProduct(@PathVariable("prodCode") int prodCode, 
		@RequestBody Product p){
	return productService.updateProductService(prodCode, p);
}
}
