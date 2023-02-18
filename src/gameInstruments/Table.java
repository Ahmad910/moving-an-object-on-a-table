package gameInstruments;

public abstract class Table {
	private int width;
	private int height;
	
	public Table(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
