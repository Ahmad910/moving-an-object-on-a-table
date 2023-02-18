package validator;

import java.util.List;

public interface Validator {

	public static final int minCommandNumber = 0;
	public static final int maxCommandNumber = 4;
	public boolean validate(List<Integer> list);
}
