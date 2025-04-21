package model;

public class CoffeeMilk {

	private Integer coffee;
	private Integer milk;
	private String result;
	private String data;
	
	public CoffeeMilk(String coffee,String milk) {
		
		this.coffee = Integer.parseInt(coffee);
		this.milk = Integer.parseInt(milk);
		setResult();
		setData();
		
	}
	
	private void setResult() {
		String result =  milk>=coffee*3 ? "濃郁拿鐵" : milk>=coffee*1.5 
						? "平衡的拿鐵咖啡":milk == coffee
						?"卡布奇諾": coffee>= milk*3 
						?"濃縮咖啡":"普通咖啡" ;
		this.result = result;
	}
	
	private void setData() {
		String data =  milk>=coffee*3 ? "牛奶的比例遠高於咖啡，味道偏向牛奶。" : milk>=coffee*1.5 
						? "牛奶與咖啡的比例較為平衡，風味溫和。":milk == coffee
						?"牛奶與咖啡的比例恰到好處，典型的卡布奇諾。": coffee>= milk*3 
						?"咖啡的比例遠高於牛奶，口感濃烈，偏向純咖啡。":"牛奶與咖啡的比例較為普通，適合日常飲用。" ;
		this.data = data;
	}
	
	
	
	public String getResult() {
		return result;
	}
	
	public String getData() {
		return data;
	}
	
	

	public Integer getCoffee() {
		return coffee;
	}

	public Integer getMilk() {
		return milk;
	}
	
	
}
