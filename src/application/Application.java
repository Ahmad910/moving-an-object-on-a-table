package application;

import java.util.List;

import game.Game;
import gameInstruments.Point;
import gameInstruments.Point2D;
import gameInstruments.RectangleTable;
import gameInstruments.Table;
import readInputAndCommands.CommandsReader;
import readInputAndCommands.InputReader;
import readInputAndCommands.Reader;

public class Application {

	public static void main(String[] args) {
		new Application().start();
	}

	private void start() {
		Reader inputReader = new InputReader();
		int[] userInput = inputReader.readFromUser().stream().mapToInt(i -> i).toArray(); 
		Reader commandsReader = new CommandsReader();
		List<Integer> sequenceOfCommands = commandsReader.readFromUser();
		Table rectangleTable = new RectangleTable(userInput[0], userInput[1]);
		Point point2D = new Point2D(userInput[2], userInput[3]);
		Game game = new Game(point2D, rectangleTable, sequenceOfCommands);
		game.startGame();
		System.out.println("The result is: "); 
		System.out.println("(" + point2D.getX() + ", " + point2D.getY() + ")");
	}
}
