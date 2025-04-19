package model;

import java.util.HashMap;
import java.util.Map;

public class DrinkOrder {

	private String type;
	private String size;
	private String ice;
	private int price;
	
	private static final Map<String, Map<String, Integer>> priceTable;
	static {
		priceTable = new HashMap<>();
		Map<String, Integer> greenTeaPrices = new HashMap<>();
		greenTeaPrices.put("S", 30);
		greenTeaPrices.put("M", 50);
		greenTeaPrices.put("L", 50);
		priceTable.put("greenTea", greenTeaPrices);
		
		Map<String, Integer> blackTeaPrices = new HashMap<>();
		blackTeaPrices.put("S", 45);
		blackTeaPrices.put("M", 55);
		blackTeaPrices.put("L", 65);
		priceTable.put("blackTea", blackTeaPrices);
		
		Map<String, Integer> milkTeaPrices = new HashMap<>();
		milkTeaPrices.put("S", 40);
		milkTeaPrices.put("M", 45);
		milkTeaPrices.put("L", 60); 
		priceTable.put("milkTea", milkTeaPrices);
	
	}

	private static final Map<String, String> iceTable;
	static {
		iceTable = new HashMap<>();
		iceTable.put("yes","有加冰");
		iceTable.put("no","去冰");
	}
		


	public DrinkOrder(String type, String size, String ice) {

		this.type = type; // 直接儲存傳入的 type (Store the passed type directly)
		this.size = size.toUpperCase(); // 將尺寸轉為大寫以匹配查找表 (Convert size to uppercase for lookup)
		this.ice = ice.toLowerCase(); // 將冰塊選項轉為小寫以匹配查找表 (Convert ice option to lowercase for lookup)
		this.price = priceTable.get(type).get(this.size);

	}

	public String getInfo() {

		String iceText = iceTable.get(ice.toLowerCase());
		return String.format("您點了一杯 %s (%s, %s)，價格為 %d 元", this.type, this.size, iceText, this.price);

	}

	public String getType() {
		return type;
	}

	public String getSize() {
		return size;
	}

	public String getIce() {
		return ice;
	}

	public int getPrice() {
		return price;
	}

}
