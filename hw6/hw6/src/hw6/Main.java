package hw6;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		StringTokenizer tokenizer = new StringTokenizer(str," ");
		
		ArrayList<String> strs = new ArrayList<String>();
		String ans = "";
		
		while(tokenizer.hasMoreElements()) {
			strs.add(tokenizer.nextToken());			
		}
		
		if(strs.size() == 3 && (strs.get(1).equals(">") || strs.get(1).equals("<") || strs.get(1).equals("="))) {
			IOperation cmp = new Comparison();
			String result = cmp.perform(strs.get(0), strs.get(2));
			switch(strs.get(1).charAt(0)) {
				case '>':
					ans = (result.equals("1"))?"true":"false";
					break;
				case '<':
					ans = (result.equals("-1"))?"true":"false";
					break;
				case '=':
					ans = (result.equals("0"))?"true":"false";
					break;
				default:
					break;
			}
		}
		else {
			for(int i=0;i<strs.size();++i) {
				if(i % 2 == 1) {
					//i is odd -> operator
					String num1 = strs.get(i-1);
					String num2 = strs.get(i+1);
					//System.out.print(num1+" "+strs.get(i)+" "+num2 + " = ");
					switch(strs.get(i).charAt(0)) {
						case '+':
							IOperation opa = new Addition();
							ans = opa.perform(num1, num2);
							break;
						case '-':
							IOperation ops = new Subtraction();
							ans = ops.perform(num1, num2);
							break;
						default:
							break;
					}
					//System.out.println(ans);
					strs.set(i+1,ans);
				}
			}
		}
		
		System.out.println(ans);
		
		s.close();
	}

}
