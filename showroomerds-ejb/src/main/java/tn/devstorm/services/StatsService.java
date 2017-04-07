package tn.devstorm.services;

import java.util.List;
import java.util.OptionalDouble;

import javax.ejb.Stateless;

import com.typicode.jsonplaceholder.Rate;

import tn.devstorm.restclient.RateResouceClient;
@Stateless
public class StatsService implements StatsServiceRemote {
	RateResouceClient rc =new RateResouceClient();
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
	
}
