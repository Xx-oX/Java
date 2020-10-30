package hw2;
import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class Hw2 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		try {
			double a, b ,c, x1, x2;
			a = scanner.nextDouble();
			b = scanner.nextDouble();
			c = scanner.nextDouble();
			String str = scanner.next();
			DecimalFormat df = new DecimalFormat(str);
			x1 = ((-b) + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
			x2 = ((-b) - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
			System.out.println(df.format(x1) + "\n" + df.format(x2));
		}
		finally {
			scanner.close();
		}
	}
}