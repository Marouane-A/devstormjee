package tn.devstorm.services;

import java.util.List;
import java.util.OptionalDouble;

import javax.ejb.Local;

import com.typicode.jsonplaceholder.Product;


@Local
public interface StatsServiceRemote {
	public OptionalDouble averageRate();
	public double sumOfRates();
	public double sumOfRatesPerUser(int id);
	public double sumOfRatesPerProduct(int id);
	public List<Product> ProductsByMostQuantity();
	public List<Product> ProductsByMinQuantity();
	public List<Product> ProductsByMaxPrice();
	public List<Product> ProductsByMinPrice();
	public List<Product> ProductsByMaxInteraction();
	public double SumOfPurchases();
	public List<Product> ProductBestOffer();
	    
}
