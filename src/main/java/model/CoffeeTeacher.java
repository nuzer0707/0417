package model;

import java.util.List;
import java.util.ArrayList;
import java.util.function.BiPredicate;

public class CoffeeTeacher {

	private Double milk;
	private Double coffee;
	
	static class CoffeeRule{
		
		private String type;
		
		private String des;
		
		private BiPredicate<Double, Double> condition;
		
		public CoffeeRule( String type , String des, BiPredicate<Double, Double> condition) {		
			this.type=type;
			this.des=des;
			this.condition= condition;
		}
		
		public boolean matches(Double milk,Double coffee ) {
			return condition.test(milk,coffee);

		}
		
		public String getResult() {
			return type+":"+des;
		}
		
		
	}
	
	private static final List<CoffeeRule> rules = new ArrayList<>();
	
	static {
		
		rules.add(new CoffeeRule("濃郁的拿鐵", "牛奶的比例遠高於咖啡，味道偏向牛奶。", 
				 (milk,coffee)->milk >= coffee*3 ));
		rules.add(new CoffeeRule("平衡的拿鐵咖啡", "牛奶與咖啡的比例較為平衡，風味溫和。", 
				 (milk,coffee)->milk >= coffee*1.5 ));		
		rules.add(new CoffeeRule("卡布奇諾", "牛奶與咖啡的比例恰到好處，典型的卡布奇諾。", 
				 (milk,coffee)->milk.equals(coffee)));		
		rules.add(new CoffeeRule("濃縮咖啡", "咖啡的比例遠高於牛奶，口感濃烈，偏向純咖啡。", 
				 (milk,coffee)->coffee >= milk*3 ));
		rules.add(new CoffeeRule("普通咖啡", "牛奶與咖啡的比例較為普通，適合日常飲用。", 
				 (milk,coffee)->true));	
	}
	
	public CoffeeTeacher (Double milk, Double coffee) {
		this.coffee=coffee;
		this.milk=milk;
	}
	
	public CoffeeTeacher (String milk, String coffee) {
		this(Double.parseDouble(milk),Double.parseDouble(coffee));
		
	}
	
	
	public String getCoffeeType() {
		return rules.stream()
					.filter(rule->rule.matches(milk, coffee))
					.findFirst()
					//.map(CoffeeRule::getResult)
					.map(rule -> rule.getResult())
					.orElse("無法辨識的咖啡類型");	
	}

	

	
	
	
	public Double getMilk() {
		return milk;
	}

	public Double getCoffee() {
		return coffee;
	}
	
	
	
	
}




