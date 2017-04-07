package tn.devstorm.services;

import java.util.OptionalDouble;

import javax.ejb.Local;


@Local
public interface StatsServiceRemote {
	public OptionalDouble averageRate();
	public double sumOfRates();
}
