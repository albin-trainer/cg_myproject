package com.cg.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.cg.entity.Product;
import com.cg.exception.ProductNotFoundException;
import com.cg.repository.ProductRepository;
import com.cg.service.ProductService;
@Component
@Transactional
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository prodRepository;
	@Override
	public Product addNewProductService(Product p) {
		p=prodRepository.save(p);
		return p;
	}
	@Override
	public Product searchProductByCodeService(int prodCode) {
		//get method throw NoSuchElementException if the product not found
		//no need to throw explicilty //findById() returns Optional<Product>
		Product p=prodRepository.findById(prodCode).get();
		
	//	Product p=prodRepository.findById(prodCode).orElseThrow(
		//		()-> new ProductNotFoundException("The "+prodCode+" not found") );
		return p;
	}
	@Override
	public Product updateProductService(int prodCode,Product p) {
		//Throw exception of prodCode not found
		Product p1=prodRepository.findById(prodCode).get();
		prodRepository.save(p);//save method used for update and insert
		return p;
	}
	@Override
	public void removeProductByCodeService(int prodCode) {
		prodRepository.deleteById(prodCode); //removes the product by only primary key
	}
	@Override
	public List<Product> allProductsService() {
		 List<Product> prodList=	prodRepository.findAll();
		return  prodList;
	}

}
