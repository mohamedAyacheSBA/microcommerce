package com.commerce.microcommerce.model;

public class ProductMarge {
	
	private Product product;
	
	private int marge;

	
	
	public ProductMarge() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ProductMarge(Product product, int marge) {
		super();
		this.product = product;
		this.marge = marge;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public int getMarge() {
		return marge;
	}



	public void setMarge(int marge) {
		this.marge = marge;
	}
	


}
