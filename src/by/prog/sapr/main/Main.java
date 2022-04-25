package by.prog.sapr.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import by.prog.sapr.main.*;

public class Main {ArrayList<Note> recs = new ArrayList<Note>();

	public static void main(String[] args) throws IOException {

		
		System.out.println("1.Add record");
		System.out.println("2.Search by date");
		System.out.println("3.Search by content");
		System.out.println("4.Delete record");
		System.out.println("Enter another symbol to exit\n-----------------------------------");

		Scanner sc = new Scanner(System.in);
		Realization real = new Realization();
		for (;;) {
			System.out.println("Enter num of operation:");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				recs = real.add(recs);
				for (Note str : recs) {
					System.out.println(str.toString());
				}
				Realization.saveNotepad(recs);
				break;
			case 2:
				Realization.searchByDate(recs);
				break;
			case 3:
				Realization.searchByText(recs);
				break;
			case 4:
				Realization.delete(recs);
				Realization.saveNotepad(recs);
				break;
			default:
				break;
			}
		}
	}
}