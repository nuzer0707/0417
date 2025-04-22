package model.ice;

import java.util.Arrays;
import java.util.List;

public class Topping {

	private List<String> toppings;
	private static final int TOPPING_PRICE = 10;

	public Topping(String[] toppingArray) {
		this.toppings = (toppingArray == null) ? null : Arrays.asList(toppingArray);

	}

	public List<String> getToppings() {
		return toppings;
	}

	public int calculateToppingPrice() {

		return (toppings == null) ? 0 : toppings.size() * TOPPING_PRICE;
	}

}
