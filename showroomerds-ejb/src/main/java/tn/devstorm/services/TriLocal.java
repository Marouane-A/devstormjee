package tn.devstorm.services;

import java.util.List;

import javax.ejb.Local;

import com.typicode.jsonplaceholder.Product;

@Local
public interface TriLocal {
	
	public List<Product> priceLowerThen(int l);
	public List<Product> priceGreaterThen(int g);
	public List<Product> priceBetween(int l, int g);

}
