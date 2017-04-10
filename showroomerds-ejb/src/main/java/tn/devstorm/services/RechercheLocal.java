package tn.devstorm.services;

import java.util.List;

import javax.ejb.Local;

import com.typicode.jsonplaceholder.Product;

@Local
public interface RechercheLocal {
	
	public List<Product> findByName(String nomP);
	public List<Product> findByCategory(String categoryP);
	public List<Product> findByBrand(String brandP);
	public List<Product> findGlobal(String critere);
	
	
}
