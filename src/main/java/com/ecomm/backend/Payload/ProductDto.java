package com.ecomm.backend.Payload;

public class ProductDto {

	private int product_id;
	private String product_name;
	private double product_prize;
	private String product_desc;
	private String product_imageName;
	private int product_quantity;
	private boolean stock;
	private boolean live;

	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDto(int product_id, String product_name, double product_prize, String product_desc,
			String product_imageName, int product_quantity, boolean stock, boolean live) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_prize = product_prize;
		this.product_desc = product_desc;
		this.product_imageName = product_imageName;
		this.product_quantity = product_quantity;
		this.stock = stock;
		this.live = live;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_prize() {
		return product_prize;
	}

	public void setProduct_prize(double product_prize) {
		this.product_prize = product_prize;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public String getProduct_imageName() {
		return product_imageName;
	}

	public void setProduct_imageName(String product_imageName) {
		this.product_imageName = product_imageName;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

}
