package validator;

import gameInstruments.Point;
import gameInstruments.Table;

public class PathValidator {
	
	public static boolean validatePath(Table table, Point point) {
		return point.getX() < table.getWidth() && point.getY() < table.getHeight()
				&& point.getX() >= 0 && point.getY() >= 0;
	}
}