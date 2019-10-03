package com.elhawary.accounting.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7469589115138001074L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	
	@OrderBy("productName asc")
	private String productName;

	private Date createdDate ;
	
	private Date updatedDate ;

	private double productDiscount ;
	
	private int productQuantity = 0 ;
	
	@Column(name = "productSellCount", nullable = false, columnDefinition = "bigint(20) default 0")
	private int productSellCount ;
	
	@Column(name = "productBuyCount", nullable = false, columnDefinition = "bigint(20) default 0")
	private int productBuyCount ;

	@Min(value = 0, message = "Product price must no be less then zero.")
	private double productBuyPrice;
	
	@Min(value = 0, message = "Product price must no be less then zero.")
	private double productSellPrice1;
	@Min(value = 0, message = "Product price must no be less then zero.")
	private double productSellPrice2;
	@Min(value = 0, message = "Product price must no be less then zero.")
	private double productSellPrice3;
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public double getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(double productDiscount) {
		this.productDiscount = productDiscount;
	}

	public int getProductSellCount() {
		return productSellCount;
	}

	public void setProductSellCount(int productSellCount) {
		this.productSellCount = productSellCount;
	}

	public double getProductBuyPrice() {
		return productBuyPrice;
	}

	public void setProductBuyPrice(double productBuyPrice) {
		this.productBuyPrice = productBuyPrice;
	}

	public double getProductSellPrice1() {
		return productSellPrice1;
	}

	public void setProductSellPrice1(double productSellPrice1) {
		this.productSellPrice1 = productSellPrice1;
	}

	public double getProductSellPrice2() {
		return productSellPrice2;
	}

	public void setProductSellPrice2(double productSellPrice2) {
		this.productSellPrice2 = productSellPrice2;
	}

	public double getProductSellPrice3() {
		return productSellPrice3;
	}

	public void setProductSellPrice3(double productSellPrice3) {
		this.productSellPrice3 = productSellPrice3;
	}

	public int getProductBuyCount() {
		return productBuyCount;
	}

	public void setProductBuyCount(int productBuyCount) {
		this.productBuyCount = productBuyCount;
	}
	
}
