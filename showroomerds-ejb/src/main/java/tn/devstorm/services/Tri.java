package tn.devstorm.services;

import java.util.Comparator;
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
public class Tri implements TriLocal {

	public static void main(String[] args) {
		Tri t = new Tri();
		System.out.println(t.priceLowerThen(800));
		//System.out.println(t.priceGreaterThen(800));
		//System.out.println(t.priceBetween(100, 200000));
	}
	
	ProductResourceClient prc = new ProductResourceClient();

	
	@Override
	public List<Product> priceLowerThen(int l) {

		List<Product> productsLower = prc.getProducts();
		return productsLower.stream().filter(p -> p.getPrice() < l).collect(Collectors.toList());
	}

	@Override
	public List<Product> priceGreaterThen(int g) {

		List<Product> productsGreater = prc.getProducts();
		return productsGreater.stream().filter(p -> p.getPrice() > g).collect(Collectors.toList());
	}

	@Override
	public List<Product> priceBetween(int l, int g) {

		List<Product> productsBetween = prc.getProducts();
		
		return productsBetween.stream().filter(p -> (p.getPrice()) > l && (p.getPrice()) < g).collect(Collectors.toList());				
	}
}
