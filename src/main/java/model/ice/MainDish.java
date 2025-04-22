package model.ice;

import java.util.Map;

public class MainDish {
	 
	private String name;
	private int price;
	
	private static final Map<String, Integer> PRICE_Map = Map.of("剉冰", 50,"豆花", 40);
	
	public MainDish(String name) {
		this.name= name;
		this.price = PRICE_Map.get(name);
	}


	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	
	
	
}