package com.ecomm.backend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int product_id;
	@Column
	private String product_name;
	@Column
	private double product_prize;
	@Column
	private String product_desc;
	@Column
	private String product_imageName;
	@Column
	private int product_quantity;
	@Column
	private boolean stock;
	@Column
	private boolean live;

	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
