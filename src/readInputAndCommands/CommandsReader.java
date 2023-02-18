package readInputAndCommands;

import java.util.ArrayList;
import java.util.List;

import validator.CommandsValidator;

public class CommandsReader extends Reader {

	@Override
	public List<Integer> readFromUser() {
		printCommands();
		printCommandsInstructions();
		List<Integer> sequenceOfCommands = readCommands();
		CommandsValidator commandsValidator = new CommandsValidator();
		while (!commandsValidator.validate(sequenceOfCommands)) {
			printCommandsInstructions();
			sequenceOfCommands = readCommands();
		}
		scanner.close();
		return sequenceOfCommands;
	}

	private void printCommands() {
		System.out.println("1 = move forward one step");
		System.out.println("2 = move backwards one step ");
		System.out.println("3 = rotate clockwise 90 degrees");
		System.out.println("4 = rotate counterclockwise 90 degrees");
		System.out.println("0 = quit simulation and print the results");
	}

	private void printCommandsInstructions() {
		System.out.println("The commands must end with 0. Commands are in "
				+ "the interval [0,4]. "
				+ "You can enter the commands in the following format:");
		System.out.println("for example: 1,2,3,4,0");
	}

	private List<Integer> readCommands() {
		String commands = scanner.next();
		List<Integer> sequenceOfCommands = new ArrayList<Integer>();
		try {
			String[] splittedCommands = commands.split(",");
			boolean wrongInput = false;
			for (String command : splittedCommands) {
				if(!isNumeric(command)) {
					printCommandsInstructions();
					wrongInput = true;
				}
			}
			while(wrongInput) {
				commands = scanner.next();
				splittedCommands = commands.split(",");
				for (String command : splittedCommands) {
					if(!isNumeric(command)) {
						printCommandsInstructions();
						break;
					} 
					wrongInput = false;
				}
			}
			for (String command : splittedCommands) {
				sequenceOfCommands.add(Integer.parseInt(command));
			}
		} catch (NumberFormatException e) {
			 System.out.println("that was not a number");
		}
		return sequenceOfCommands;

	}
}
