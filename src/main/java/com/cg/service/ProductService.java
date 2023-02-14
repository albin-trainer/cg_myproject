package com.cg.service;

import java.util.List;

import com.cg.entity.Product;

public interface ProductService {
	Product addNewProductService(Product p);
	Product searchProductByCodeService(int prodCode);
	Product updateProductService(int prodId,Product p);
	void removeProductByCodeService(int prodCode);
	List<Product> allProductsService();
}
