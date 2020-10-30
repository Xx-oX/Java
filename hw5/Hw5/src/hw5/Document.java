package hw5;

public class Document {
	protected String text;
	
	public String toString() {
		return text;
	}
	
	public void setText(String str) {
		text = str;
	}
}

class Email extends Document {
	private String sender;
	private String recipient;
	private String title;
	
	public String toString() {
		String output = "From: " + sender 
			+ "\nTo: " + recipient + "\nTitle: " + title + "\n" + text;
		return output;
	}
	
	public void setSender(String str) {
		sender = str;
	}
	
	public String getSender() {
		return sender;
	}
	
	public void setRecipient(String str) {
		recipient = str;
	}
	
	public String getRecipient() {
		return recipient;
	}
	
	public void setTitle(String str) {
		title = str;
	}
	
	public String getTitle() {
		return title;
	}
}

class File extends Document{
	private String pathname;
	
	public String toString() {
		String output = "Path: " + pathname + "\n" + text;
		return output;
	}
	
	public void setPathname(String str) {
		pathname = str;
	}
	
	public String getPathname() {
		return pathname;
	}
}
