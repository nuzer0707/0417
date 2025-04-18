package util;

public class Util {

	//判斷是否是Double
	public static boolean isDouble(String data) {
		try {
			Double.parseDouble(data);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	//判斷是否是數字1
	public static boolean isNum1(String data) {
		try {
			Integer.parseInt(data);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	//判斷是否是數字2
	public static boolean isNum2(String data) {
		if(data==null) return false;
		return data.matches("\\d+");
	}
	
	
	
}
