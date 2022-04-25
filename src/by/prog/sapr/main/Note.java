package by.prog.sapr.main;

public class Note {
	private static String date;
	private static String text;

	public Note(){}
	
	public Note(String date, String text) {
		this.text = text;
		this.date = date;
	}
	
	public static String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public static String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	public String toString() {
		return "[" + date + "]" + "{" + text + "}";
	}
}