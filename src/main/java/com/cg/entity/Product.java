package com.cg.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
//@Table(name = "xxxxx")
public class Product {
	@Id
private int productCode;
	@Column(nullable = false)
	@NotBlank(message = "shud enter pname")
private String productName;
	
	@Max(value = 1000000,message = "shud not more than 10000")
	@Min(value = 1,message = "shud not less than 1")
private float price;
	
@JsonFormat(pattern = "dd-MM-yyyy")
private LocalDate manufactureDate;

public Product() {
	// TODO Auto-generated constructor stub
}

public Product(int productCode, @NotBlank(message = "shud enter pname") String productName,
		@Max(value = 10000, message = "shud not more than 10000") @Min(value = 1, message = "shud not less than 1") float price) {
	super();
	this.productCode = productCode;
	this.productName = productName;
	this.price = price;
}

@OneToMany(mappedBy = "product")
@JsonManagedReference
private List<Review> reviewList;


public LocalDate getManufactureDate() {
	return manufactureDate;
}
public void setManufactureDate(LocalDate manufactureDate) {
	this.manufactureDate = manufactureDate;
}
public List<Review> getReviewList() {
	return reviewList;
}
public void setReviewList(List<Review> reviewList) {
	this.reviewList = reviewList;
}


public int getProductCode() {
	return productCode;
}
public void setProductCode(int productCode) {
	this.productCode = productCode;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}

}
