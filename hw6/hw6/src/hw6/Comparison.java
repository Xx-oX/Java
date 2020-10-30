package hw6;

public class Comparison implements IOperation{

	@Override
	public String perform(String num1, String num2) {
		if(num1.equals(num2)) {
			return "0";
		}
		else if(larger(num1,num2)) {
			return "1";
		}
		else {
			return "-1";
		}
	}
	
	private boolean larger(String a, String b) {
		if(a.substring(0, 1).equals("-")) {
			if(b.substring(0, 1).equals("-")) {
				//a- b-
				return absComp(b.substring(1),a.substring(1));
			}
			else {
				//a- b+
				return false;
			}
		}
		else {
			if(b.substring(0, 1).equals("-")) {
				//a+ b-
				return true;
			}
			else {
				//a+ b+
				return absComp(a,b);
			}
		}
	}
	
	private boolean absComp(String a, String b) {
		if(a.length() == b.length()) {
			if(a.compareTo(b) >= 0) {
				return true;
			}
			else if(a.compareTo(b) < 0) {
				return false;
			}
		}
		return a.length() > b.length();
	}

}
