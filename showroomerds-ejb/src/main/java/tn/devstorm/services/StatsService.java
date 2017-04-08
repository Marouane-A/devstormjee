package tn.devstorm.services;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import javax.ejb.Stateless;

import com.typicode.jsonplaceholder.Product;
import com.typicode.jsonplaceholder.Purchase;
import com.typicode.jsonplaceholder.Rate;

import tn.devstorm.restclient.ProductResourceClient;
import tn.devstorm.restclient.PurchaseResourceClient;
import tn.devstorm.restclient.RateResouceClient;
@Stateless
public class StatsService implements StatsServiceRemote {
	RateResouceClient rc =new RateResouceClient();
	ProductResourceClient pc = new ProductResourceClient();
	PurchaseResourceClient prc = new PurchaseResourceClient();
	@Override
	public OptionalDouble averageRate() {
		List<Rate> rates = rc.getRates();
    	return rates.stream().mapToDouble(p->p.getMark()).average();
	}
	@Override
	public double sumOfRates() {
		List<Rate> rates = rc.getRates();
    	return rates.stream().count();
		
	}
	@Override
	public double sumOfRatesPerUser(int id){
    	List<Rate> rates = rc.getRates();
    	return rates.stream().filter(m->m.getUserId()==id).count();
    }
    public double sumOfRatesPerProduct(int id){
    	List<Rate> rates = rc.getRates();
    	return rates.stream().filter(m->m.getProductId()==id).count();
    }
    @Override
	public List<Product> ProductsByMostQuantity(){
    	List<Product> products = pc.getProducts();
    	return products.stream().sorted(Comparator.comparing(Product::getQuantity).reversed())
    			.collect(Collectors.toList());
    }
    @Override
	public List<Product> ProductsByMinQuantity(){
    	List<Product> products = pc.getProducts();
    	return products.stream().sorted(Comparator.comparing(Product::getQuantity))
    			.collect(Collectors.toList());
    }
    @Override
	public List<Product> ProductsByMaxPrice(){
    	List<Product> products = pc.getProducts();
    	return products.stream().sorted(Comparator.comparing(Product::getPrice).reversed())
    			.collect(Collectors.toList());
    }
    @Override
	public List<Product> ProductsByMinPrice(){
    	List<Product> products = pc.getProducts();
    	return products.stream().sorted(Comparator.comparing(Product::getPrice))
    			.collect(Collectors.toList());
    }
    @Override
	public List<Product> ProductsByMaxInteraction(){
    	List<Product> products = pc.getProducts();
    	return products.stream().sorted((e1,e2)->e1.getInteractions().size()-(e2.getInteractions()).size())
    			.collect(Collectors.toList());
    }
    @Override
	public double SumOfPurchases(){
    	List<Purchase> purchases=prc.getPurchases();
    	return purchases.stream().count();
    }
    @Override
	public List<Product> ProductBestOffer(){
    	List<Product> products = pc.getProducts();
    	return products.stream().sorted(Comparator.comparing(Product::getDiscount).reversed())
    			.collect(Collectors.toList());
    }
	
}
