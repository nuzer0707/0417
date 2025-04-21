package case01;

import java.util.Map;

public class coffeeOrder {

	private String type;
	private String size;
	private boolean sugar;
	private int price;
	
	private static final Map<String, Map<String, Integer>> priceTable = Map.of(
			"Latte",Map.of("S",50,"M",70,"L",90),
			"Mocha",Map.of("S",45,"M",55,"L",65),
			"Americano"	,Map.of("S",40,"M",45,"L",60),
			"Cappuccino",Map.of("S",55,"M",80,"S",100));
	
	private static final Map<String, String> sizeMap = Map.of("S","小","M","中","L","大");
	private static final Map<Boolean, String> sugarMap =Map.of(true,"有糖",false,"無糖");
	
	public coffeeOrder(String type,String size,String sugar,int price) {
		
		this.type= type;
		this.size= size;
		this.sugar = Boolean.parseBoolean(sugar);
		this.price= priceTable.get(type).get(size);

	}
	
	public String getinfo() {

		String sizetext = sizeMap.get(size);
		String sugarText = sugarMap.get(sugar);
		return String.format("您點了一杯 %杯 %s 咖啡 價格: %d 元", sizetext, type,sugarText,price);
	}
	
	
}
