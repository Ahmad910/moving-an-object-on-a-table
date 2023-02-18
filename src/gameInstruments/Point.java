package gameInstruments;

public class Point {
	private int x;
	private int y;
	private Direction direction;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		direction = Direction.NORTH;
	}
	
	public void setX(int newX) {
		this.x = newX;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int newY) {
		this.y = newY;
	}
	
	public int getY() {
		return y;
	}
	
	public void setDirection(Direction newDirection) {
		this.direction = newDirection;
	}
	
	public Direction getDirection() {
		return direction;
	}
}

