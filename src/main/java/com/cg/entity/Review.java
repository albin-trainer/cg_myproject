package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Review {
	@Id
	@GeneratedValue
private int revId;
private String reviewerName;
private String content;
private float ratings;
private LocalDate date;
@ManyToOne
@JoinColumn(name="prodId")
@JsonBackReference
private Product product;



public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public int getRevId() {
	return revId;
}
public void setRevId(int revId) {
	this.revId = revId;
}
public String getReviewerName() {
	return reviewerName;
}
public void setReviewerName(String reviewerName) {
	this.reviewerName = reviewerName;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public float getRatings() {
	return ratings;
}
public void setRatings(float ratings) {
	this.ratings = ratings;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}


}
