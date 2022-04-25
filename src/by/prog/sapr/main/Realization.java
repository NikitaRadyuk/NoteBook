package by.prog.sapr.main;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Realization {

	public static File file = new File("YourNotepad.txt");
	public static Scanner scan = new Scanner(System.in);

	private static Note obj;
	public ArrayList<Note> add(ArrayList<Note> recs) {
		
		 obj = new Note();
		System.out.println("Enter Date");
		String s = scan.nextLine();
		System.out.println("Enter text");
		String a = scan.nextLine();
		obj.setDate(s);
		obj.setText(a);
		recs.add(new Note (s,a));
		obj = null;
		return recs;
	}

	public static void searchByDate(ArrayList<Note> recs) {
		System.out.println("Enter date like dd.mm.yyyy:");
		String s = scan.nextLine();

		for (int i = 0; i < recs.size(); i++) {
			if (recs.get(i).getDate().equals(s)) {
				System.out.println("{" + recs.get(i).getDate() + "}  {" + recs.get(i).getText() + "}");
			}
		}
	}

	public static void searchByText(ArrayList<Note> recs) {
		System.out.println("Enter your words:");
		String s = scan.nextLine();

		for (int i = 0; i < recs.size(); i++) {
			if (recs.get(i).getText().contains(s)) {
				System.out.println("{" + recs.get(i).getDate() + "}     {" + recs.get(i).getText() + "}");
			} else {
				System.out.println("Notes not found:(");
			}
		}
	}

	public static ArrayList<Note> delete(ArrayList<Note> recs) {
		System.out.println("1.Delete Notes by Date\n2.Delete Notes by words");
		int count = scan.nextInt();
		if (count == 1) {
			searchByDate(recs);
			System.out.println("Enter index of your Note that u want to delete:");
			int index = scan.nextInt();
			recs.remove(index);
		}
		if (count == 2) {
			searchByText(recs);
			System.out.println("Enter index of your Note that u want to delete:");
			int index = scan.nextInt();
			recs.remove(index);
		}
		return recs;
	}

	public static void saveNote(Note note) throws IOException {
		note = new Note();
		PrintWriter pw = new PrintWriter(new FileWriter(file, true));
		pw.println(note);
		pw.close();
	}

	public static void saveNotepad(ArrayList<Note> recs) throws IOException {

		PrintWriter pw = new PrintWriter(new FileWriter(file));
		for (Note str : recs) {
			pw.println(str);
		}
		pw.close();
	}

	public void viewNotes() throws FileNotFoundException {
		Scanner scan = new Scanner(file);

		System.out.println("Your notes:");
		while (scan.hasNextLine()) {
			System.out.println(scan.nextLine());
		}

		System.out.println();
	}

}
