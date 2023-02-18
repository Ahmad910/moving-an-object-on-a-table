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
				movePoint(1, direction);
				break;
			case 2:
				movePoint(2, direction);
				break;
			case 3:
				moveDirection(3, direction);
				break;
			case 4:
				moveDirection(4, direction);
				break;
			case 0:
				break;
			}
			if (!checkIfPointIsOnTheTable()) {
				return;
			}
		}
	}

	private void movePoint(int command, Direction direction) {
		if (command == 1) {
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
		} else if (command == 2) {
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
		}
	}

	private void moveDirection(int command, Direction direction) {
		if (command == 3) {
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
		} else if (command == 4) {
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
		}
	}

	private boolean checkIfPointIsOnTheTable() {
		if (!PathValidator.validatePath(table, point)) {
			point.setX(-1);
			point.setY(-1);
			return false;
		}
		return true;
	}

}
