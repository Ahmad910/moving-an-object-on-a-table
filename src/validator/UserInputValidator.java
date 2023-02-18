package validator;

import java.util.List;

public class UserInputValidator implements Validator {
	
	public boolean validateCoordinations(int coordination, int dimension) {
		return coordination >= 0 && coordination < dimension;
	}

	@Override
	public boolean validate(List<Integer> input) {
		return validateDimension(input.get(0)) && validateDimension(input.get(1));
	}
	
	private boolean validateDimension(int dimension) {
		return dimension > 0;
	}
}
