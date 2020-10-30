package hw1;

public class PigLatin {
	public static void main(String[] args) {
		for(String str : args) {
			if(
				str.charAt(0)=='a'||str.charAt(0)=='e'||str.charAt(0)=='i'||str.charAt(0)=='o'||str.charAt(0)=='u'
				|| str.charAt(0)=='A'||str.charAt(0)=='E'||str.charAt(0)=='I'||str.charAt(0)=='O'||str.charAt(0)=='U'					
			) {
				//if start with vowel
				str = str.substring(0,1).toUpperCase() + str.substring(1) + "ay";
			}
			else {
				//if start with consonant
				str = str.substring(1,2).toUpperCase() + str.substring(2) + str.substring(0,1) + "ay";
			}
			
			System.out.print(str+" ");
		}
	}
}
