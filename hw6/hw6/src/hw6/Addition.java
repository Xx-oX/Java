package hw6;

public class Addition implements IOperation{

	@Override
	public String perform(String num1, String num2) {
		if(num1.substring(0, 1).equals("-")) {
			if(num2.substring(0, 1).equals("-")) {
				//num1- num2-
				return "-" + Add(num1.substring(1), num2.substring(1));
			}
			else {
				//num1- num2+ -> num2 - num1
				return Subtraction.Sub(num2, num1.substring(1));
			}
		}
		else {
			if(num2.substring(0, 1).equals("-")) {
				//num1+ num2- -> num1 - num2
				return Subtraction.Sub(num1, num2.substring(1));
			}
			else {
				//num1+ num2+
				return Add(num1, num2);
			}
		}
	}
	
	public static String Add(String num1, String num2) {
		String ans = "";
		int carry = 0;
		
		if(num1.length() < num2.length()) {
			//num1 < num2 -> swap
			String tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		
		int sizeNum1 = num1.length();
		int sizeNum2 = num2.length();
		
		for(int i = 0; i < sizeNum1-sizeNum2; ++i) {
			//987 -> 0987
			num2 = "0" + num2;
		}
		
		for(int i = sizeNum1-1; i >= 0; --i) {
			int a = num1.charAt(i) - 48;
			int b = num2.charAt(i) - 48;
			int result = a + b + carry;
			carry = result / 10;
			ans = (result % 10) + ans;
		}

		if(carry != 0) {
			ans = carry + ans;
		}
		return ans;
	}
}
