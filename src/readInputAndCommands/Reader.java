package readInputAndCommands;

import java.util.List;
import java.util.Scanner;

public abstract class Reader {
	protected Scanner scanner;
	
	public Reader() {
		scanner = new Scanner(System.in);
	}
	
	public abstract List<Integer> readFromUser();
	
}
