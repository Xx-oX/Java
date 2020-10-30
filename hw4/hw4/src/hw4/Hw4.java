package hw4;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Hw4 {
	public static boolean end(double a, double b) {
		double d = Math.abs(a - b);
		return (d / a) <= 0.01f;
	}
	
	public static void main(String args[]) 
	{
		Scanner sca = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.##");
		double n = sca.nextDouble();
		double guess = Double.parseDouble(df.format(n/2)), r, lastGuess;
		do {
			lastGuess = guess;
			//r = Double.parseDouble(df.format(n / guess));
			//guess = Double.parseDouble(df.format((guess + r) / 2));
			r = n / guess;
			guess = (guess + r) / 2;
		}
		while(!end(guess, lastGuess));	
		System.out.println(df.format(guess));
		sca.close();
	}
}
