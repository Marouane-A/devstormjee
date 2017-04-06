package com.typicode.jsonplaceholder;

import java.util.ArrayList;
import java.util.List;

public class Showroom {

	private int showroomId;
	private List<Showroomer> showroomers = new ArrayList<Showroomer>();
	private List<Product> products = new ArrayList<Product>();
	
	public Showroom() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Showroom(int showroomId, List<Showroomer> showroomers, List<Product> products) {
		super();
		this.showroomId = showroomId;
		this.showroomers = showroomers;
		this.products = products;
	}
	public int getShowroomId() {
		return showroomId;
	}
	public void setShowroomId(int showroomId) {
		this.showroomId = showroomId;
	}
	public List<Showroomer> getShowroomers() {
		return showroomers;
	}
	public void setShowroomers(List<Showroomer> showroomers) {
		this.showroomers = showroomers;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
