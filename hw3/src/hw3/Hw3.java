package hw3;
import java.util.Scanner;

public class Hw3 {
	static boolean find(int a) {
		if(a == 0) {return false;}
		while(a%2 == 0) a = a/2;
		while(a%3 == 0) a = a/3;
		while(a%5 == 0) a = a/5;
		return a == 1;
	}
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		try {
			String input = scanner.next();
			if(input.charAt(0) == 'X') {
				int a = Integer.parseInt(input.substring(2));
				System.out.println(find(a));
			}
			else if(input.charAt(0) == 'Y') {
				int b = Integer.parseInt(input.substring(2));
				int x = 1;
				int cnt = 0;
				while(true) {
					if(cnt == b) {
						break;
					}
					if(find(x)) {
						cnt++;
					}
					x++;
				}
				System.out.println(x-1);
			}
			else {
				//error input
				System.out.println("error input!");
			}
		}
		catch(Exception e) {
			//error input
			System.out.println("error input!");
		}
		finally {
			scanner.close();
		}
	} 
}
