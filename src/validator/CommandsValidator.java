package validator;

import java.util.List;

public class CommandsValidator implements Validator {
	
	
	@Override
	public boolean validate(List<Integer> sequenceOfCommands) {
		return validateCommands(sequenceOfCommands);
	}
	
	private boolean validateCommands(List<Integer> sequenceOfCommands) {
		boolean validatorForEndCommand =  sequenceOfCommands.get(sequenceOfCommands.size() - 1) == 0;
		boolean validatorForCommandNumber = false;
		for(Integer command : sequenceOfCommands) {
			validatorForCommandNumber = (command >= minCommandNumber) && (command <= maxCommandNumber);
			if(!validatorForCommandNumber) {
				break;
			}
 		}
		return validatorForEndCommand && validatorForCommandNumber;
	}

}
