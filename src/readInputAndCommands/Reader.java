package readInputAndCommands;

import java.util.List;
import java.util.Scanner;

public abstract class Reader {
	protected Scanner scanner;
	
	public Reader() {
		scanner = new Scanner(System.in);
	}
	

	protected static boolean isNumeric(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public abstract List<Integer> readFromUser();
	
}
