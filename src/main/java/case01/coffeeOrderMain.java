package case01;

import java.util.Map;

public class coffeeOrderMain {

	public static void main(String[] args) {	


		Map<String, Map<String, Integer>> priceTable = Map.of(
			"Latte",Map.of("S",50,"M",70,"L",90),
			"Mocha",Map.of("S",45,"M",55,"L",65),
		    "Americano"	,Map.of("S",40,"M",45,"L",60),
		    "Cappuccino",Map.of("S",55,"M",80,"L",100));
		
		System.out.println(priceTable);
		
	}

}
