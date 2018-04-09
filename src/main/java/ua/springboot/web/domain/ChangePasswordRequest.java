package ua.springboot.web.domain;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.enumeration.UserRole;
import ua.springboot.web.validator.CheckPasswordsMatch;


@NoArgsConstructor
@Getter
@Setter
@CheckPasswordsMatch
public class ChangePasswordRequest {
    
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private String address;
	private String telephone;
	private int age;
	private UserRole role;
	private String imagePath;
	private String isActivated;
	
	@NotEmpty private String password;
	@NotEmpty private String passwordConfirmation;
	@NotEmpty private String newPassword;
    
}
