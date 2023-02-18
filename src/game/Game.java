package game;

import java.util.List;

import gameInstruments.Direction;
import gameInstruments.Point;
import gameInstruments.Table;
import validator.PathValidator;

public class Game {

	private Point point;
	private Table table;
	private List<Integer> sequenceOfCommands;

	public Game(Point point, Table table, List<Integer> sequenceOfCommands) {
		this.point = point;
		this.table = table;
		this.sequenceOfCommands = sequenceOfCommands;
	}

	public void startGame() {
		for (int command : sequenceOfCommands) {
			Direction direction = point.getDirection();
			switch (command) {
			case 1:
				switch (direction) {
				case NORTH:
					point.setY(point.getY() - 1);
					break;
				case SOUTH:
					point.setY(point.getY() + 1);
					break;
				case EAST:
					point.setX(point.getX() + 1);
					break;
				case WEST:
					point.setX(point.getX() - 1);
					break;
				}
				if(!checkIfPointIsOnTheTable()) {
					return;
				}
				break;
			case 2:
				switch (direction) {
				case NORTH:
					point.setY(point.getY() + 1);
					break;
				case SOUTH:
					point.setY(point.getY() - 1);
					break;
				case EAST:
					point.setX(point.getX() - 1);
					break;
				case WEST:
					point.setX(point.getX() + 1);
					break;
				}
				if(!checkIfPointIsOnTheTable()) {
					return;
				}
				break;
			case 3:
				switch (direction) {
				case NORTH:
					point.setDirection(Direction.EAST);
					break;
				case SOUTH:
					point.setDirection(Direction.WEST);
					break;
				case EAST:
					point.setDirection(Direction.SOUTH);
					break;
				case WEST:
					point.setDirection(Direction.NORTH);
					break;
				}
				break;
			case 4:
				switch (direction) {
				case NORTH:
					point.setDirection(Direction.WEST);
					break;
				case SOUTH:
					point.setDirection(Direction.EAST);
					break;
				case EAST:
					point.setDirection(Direction.NORTH);
					break;
				case WEST:
					point.setDirection(Direction.SOUTH);
					break;
				}
				break;
			case 0:
				break;
			}
		}
	}
	
	private boolean checkIfPointIsOnTheTable() {
		if(!PathValidator.validatePath(table, point)) {
			point.setX(-1);
			point.setY(-1);
			return false;
		}
		return true;
	}

}
