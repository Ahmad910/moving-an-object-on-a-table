package gameInstruments;

public class Point3D extends Point {

	private int z;
	
	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	public void setZ(int newZ) {
		this.z = newZ;
	}
	
	public int getZ() {
		return z;
	}
}
