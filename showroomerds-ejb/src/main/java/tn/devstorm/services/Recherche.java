package tn.devstorm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.typicode.jsonplaceholder.Product;

import tn.devstorm.restclient.ProductResourceClient;

@Stateless
public class Recherche implements RechercheLocal {

	public static void main(String[] args) {
		Recherche r = new Recherche();
		// System.out.println(r.findByName("jupe"));
		// System.out.println(r.findByCategory("Femmes"));
		// System.out.println(r.findByBrand("Zara"));
		System.out.println(r.findGlobal("jupe"));
	}
	
	ProductResourceClient prc = new ProductResourceClient();

	

	@Override
	public List<Product> findByName(String nomP) {

		List<Product> products = prc.getProducts();
		return products.stream().filter(P -> P.getName().equals(nomP)).collect(Collectors.toList());

	}

	@Override
	public List<Product> findByCategory(String categoryP) {

		List<Product> products = prc.getProducts();
		return products.stream().filter(P -> P.getCategory().equals(categoryP)).collect(Collectors.toList());

	}

	@Override
	public List<Product> findByBrand(String brandP) {

		List<Product> products = prc.getProducts();
		return products.stream().filter(P -> P.getBrand().equals(brandP)).collect(Collectors.toList());

	}

	@Override
	public List<Product> findGlobal(String critere) {

		
		List<Product> result = null;
		List<Product> resultProductName = findByName(critere);
		List<Product> resultProductBrand = findByBrand(critere);
		List<Product> resultProductCategory = findByCategory(critere);
			
		if (!findByName(critere).isEmpty()) {
			result = resultProductName;
		} else if (!findByBrand(critere).isEmpty()) {
			result = resultProductBrand;
		} else if (!findByCategory(critere).isEmpty()) {
			result = resultProductCategory;
		}
		
		return result;
	}

}
