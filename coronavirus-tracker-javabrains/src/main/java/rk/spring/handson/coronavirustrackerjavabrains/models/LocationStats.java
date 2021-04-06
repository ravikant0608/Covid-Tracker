package rk.spring.handson.coronavirustrackerjavabrains.models;

public class LocationStats {
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getpopulation() {
		return population;
	}
	public void setpopulation(String string) {
		this.population = string;
	}
	@Override
	public String toString() {
		return "LocationStats [state=" + state + ", country=" + country + ", population=" + population + "]";
	}
	private String state;
	private String country;
	private String population;
	
	}
	


