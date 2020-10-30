package hw6;

public class Subtraction implements IOperation{

	@Override
	public String perform(String num1, String num2) {
		if(num1.substring(0, 1).equals("-")) {
			if(num2.substring(0, 1).equals("-")) {
				//num1- num2-
				String ans = Sub(num1.substring(1), num2.substring(1));
				if(ans.substring(0,1).equals("-")) {
					//--123 = 123
					ans = ans.substring(1);
				}
				return "-" + ans;
			}
			else {
				//num1- num2+ -> num2 - num1
				return "-" + Addition.Add(num1.substring(1), num2);
			}
		}
		else {
			if(num2.substring(0, 1).equals("-")) {
				//num1+ num2- -> num1 - num2
				return Addition.Add(num1, num2.substring(1));
			}
			else {
				//num1+ num2+
				return Sub(num1, num2);
			}
		}
	}
	
	public static String Sub(String num1, String num2) {
		String sign = "";
		String ans = "";
		int carry = 0;
		
		if(num1.length() < num2.length() || (num1.length() == num2.length() && num1.compareTo(num2) < 0)) {
			//num1 < num2 -> swap
			sign = "-";
			String tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		
		int sizeNum1 = num1.length();
		int sizeNum2 = num2.length();
		
		for(int i=0; i < sizeNum1-sizeNum2; ++i) {
			num2 = "0" + num2;
		}
		
		for(int i = sizeNum1-1; i >= 0; --i) {
			int result = num1.charAt(i) - num2.charAt(i) + carry;
			if(result < 0) {
				result += 10;
				carry = -1;
			}
			else {
				carry = 0;
			}
			ans = result + ans;
		}	
		return sign + ans;
	}
}
