package hw5;

import java.util.Scanner;
import hw5.Document;

public class Main {
	public static void main(String[] args) 
	{	
		Scanner scanner = new Scanner(System.in);
		String mode = scanner.nextLine();
		String type = scanner.nextLine();
		if(type.equals("Document")) {
			String content = scanner.nextLine();
			Document document = new Document();
			document.setText(content);
			
			if(mode.equals("A")) {
				System.out.println(document.toString());
			}
			else if(mode.equals("B")) {
				String str = scanner.nextLine();
				System.out.println(document.toString().contains(str));
			}
			else if(mode.equals("C")){
				String str1 = scanner.nextLine();
				String str2 = scanner.nextLine();
				if(str1.equals("text")) {
					document.setText(str2);
				}
				else {
					System.out.println("Wrong input!!");
				}
				System.out.println(document.toString());
			}
			else {
				System.out.println("Wrong input!!");
			}
			
		}
		else if(type.equals("Email")) {
			String[] input = new String[4];
			for(int i=0;i<4;++i) {
				input[i] = scanner.nextLine();
			}
			Email email = new Email();
			email.setSender(input[0]);
			email.setRecipient(input[1]);
			email.setTitle(input[2]);
			email.setText(input[3]);
			
			if(mode.equals("A")) {
				System.out.println(email.toString());
			}
			else if(mode.equals("B")) {
				String str = scanner.nextLine();
				System.out.println(email.toString().contains(str));
			}
			else if(mode.equals("C")){
				String str1 = scanner.nextLine();
				String str2 = scanner.nextLine();
				if(str1.equals("text")) {
					email.setText(str2);
				}
				else if(str1.equals("sender")) {
					email.setSender(str2);
				}
				else if(str1.equals("recipient")) {
					email.setRecipient(str2);
				}
				else if(str1.equals("title")) {
					email.setTitle(str2);
				}
				else {
					System.out.println("Wrong input!!");
				}
				System.out.println(email.toString());
			}
			else {
				System.out.println("Wrong input!!");
			}
			
		}
		else if(type.equals("File")) {
			String[] input = new String[2];
			for(int i=0;i<2;++i) {
				input[i] = scanner.nextLine();
			}
			File file = new File();
			file.setPathname(input[0]);
			file.setText(input[1]);
			
			if(mode.equals("A")) {
				System.out.println(file.toString());
			}
			else if(mode.equals("B")) {
				String str = scanner.nextLine();
				System.out.println(file.toString().contains(str));
			}
			else if(mode.equals("C")){
				String str1 = scanner.nextLine();
				String str2 = scanner.nextLine();
				if(str1.equals("text")) {
					file.setText(str2);
				}
				else if(str1.equals("pathname")) {
					file.setPathname(str2);
				}
				else {
					System.out.println("Wrong input!!");
				}
				System.out.println(file.toString());
			}
			else {
				System.out.println("Wrong input!!");
			}
			
		}
		else {
			System.out.println("Wrong input!!");
		}
		scanner.close();
	}
}
