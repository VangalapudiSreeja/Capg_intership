package com.capg.msc.myshoppingcart.exception;

public class InvalidProductCost extends Exception {
	
	private int productCost;

	public InvalidProductCost() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InvalidProductCost(int productCost) {
		super();
		this.productCost = productCost;
	}

	public int getProductCost() {
		return productCost;
	}

	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}

	public InvalidProductCost(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidProductCost(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidProductCost(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidProductCost(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
