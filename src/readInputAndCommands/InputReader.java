package readInputAndCommands;

import java.util.ArrayList;
import java.util.List;

import validator.UserInputValidator;

public class InputReader extends Reader {

	@Override
	public List<Integer> readFromUser() {
		List<Integer> input = new ArrayList<Integer>();
		int[] dimensions = readDimensions();
		UserInputValidator userInputValidator = new UserInputValidator();
		while (!userInputValidator.validate(List.of(dimensions[0], dimensions[1]))) {
			System.out.println("Dimensions must be > 0, please enter positive " + "dimensions again:");
			dimensions = readDimensions();
		}
		input.add(dimensions[0]);
		input.add(dimensions[1]);
		int[] coordinations = readCoordinations();
		while (!userInputValidator.validateCoordinations(coordinations[0], dimensions[0])
				|| !userInputValidator.validateCoordinations(coordinations[1], dimensions[1])) {
			System.out.println("Coordinations cannot be negative or bigger than "
					+ "dimensions, please enter the coordinations again:");
			coordinations = readCoordinations();
		}
		input.add(coordinations[0]);
		input.add(coordinations[1]);
		return input;
	}

	private int[] readDimensions() {
		System.out.print("Enter the width of the table: ");
		int width = readNumber();
		System.out.print("Enter the height of the table: ");
		int height = readNumber();
		int[] dimensions = { width, height };
		return dimensions;
	}

	private int[] readCoordinations() {
		System.out.println("Enter the cordination of the point:");
		System.out.print("Enter x: ");
		int x = readNumber();
		System.out.print("Enter y: ");
		int y = readNumber();
		int[] coordinations = { x, y };
		return coordinations;
	}

	private int readNumber() {
		String string = scanner.next();
		while (!isNumeric(string)) {
			System.out.println("It must be a positive integer. Please enter it again.");
			string = scanner.next();
		}
		int number = Integer.parseInt(string);
		return number;
	}
}
