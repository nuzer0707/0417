package case03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.*;

public class PhonePlan {

	private Integer time;
	private Integer webGB;
	
	static class PhoneRule {
		
		private String type;
		
		private Integer price;
		
		private BiPredicate<Integer, Integer> condition;

		public PhoneRule(String type,Integer price ,BiPredicate<Integer, Integer> condition) {
			this.type = type;
			this.price = price;
			this.condition = condition;

		}
		
		public boolean matches(Integer time,Integer webGB) {

			return condition.test(time, webGB);
		}
		
		public String getResult() {
			return type + ": $ "+ price;
		}
		
	}

	//通話 > 1000 分鐘 or 流量 > 50 GB → 商務型($1499)
	//通話 > 500 分鐘 and 流量 > 10 GB → 一般用戶型($660)
	//流量 < 1 GB and 通話 < 200 分鐘 → 長輩節省型($200)

	private static final List<PhoneRule> rules = new ArrayList<>();
	
	static {
		rules.add(new PhoneRule("商務型",1499,(time,webGB)->time>1000 || webGB>50));
		rules.add(new PhoneRule("一般用戶型",660,(time,webGB)->time>500 && webGB>10));
		rules.add(new PhoneRule("長輩節省型",200,(time,webGB)->time<200 && webGB>1));
		
	}
	
	public PhonePlan (Integer time,Integer webGB) {
		
		this.time=time;
		this.webGB=webGB;
	}
	
	public String getPhoneType() {
		return rules.stream()
					.filter(rule->rule.matches(time, webGB))
					.findFirst()
					.map(PhoneRule::getResult)
					.orElse("無適合方案");
	}
	
	
	public Integer getTime() {
		return time;
	}

	public Integer getWebGB() {
		return webGB;
	}
	
	
	
	
}
