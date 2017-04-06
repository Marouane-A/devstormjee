package com.typicode.jsonplaceholder;



public class Product {
	int productId;
	String name;
	String brand;
	String category;
	float discount;
	float price;
	int quantity;
	float tva;
	String interactions;
	public Product() {
		super();
	}

	public Product(int productId, String name, String brand, String category, float discount, float price, int quantity,
			float tva,String interactions) {
		super();
		this.productId = productId;
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.discount = discount;
		this.price = price;
		this.quantity = quantity;
		this.tva = tva;
		this.interactions=interactions;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", brand=" + brand + ", category=" + category
				+ ", discount=" + discount + ", price=" + price + ", quantity=" + quantity + ", tva=" + tva + "]";
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTva() {
		return tva;
	}
	public void setTva(float tva) {
		this.tva = tva;
	}

	public String getInteractions() {
		return interactions;
	}

	public void setInteractions(String interactions) {
		this.interactions = interactions;
	}
	

}
