package ua.springboot.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.springboot.web.domain.base.ChangePasswordRequest;

@Component
public class CheckPasswordsMatchValidatorChange implements ConstraintValidator<CheckPasswordsMatch, ChangePasswordRequest> {

	@Override
	public void initialize(CheckPasswordsMatch constraintAnnotation) {

	}

	@Override
	public boolean isValid(ChangePasswordRequest user, ConstraintValidatorContext context) {
		
		if(user.getPassword() == null || user.getPasswordConfirmation() == null) {
			return false;
		}
		
		if(user.getPassword().equals(user.getPasswordConfirmation())) {
			return true;
		}
		
		
		return false;
	}

}