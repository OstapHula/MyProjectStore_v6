package ua.springboot.web.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.enumeration.UserRole;

@Getter
@Setter
@NoArgsConstructor
public class UserProfileRequest {
    
    	private int id;
    	private String email;
	private String firstName;
	private String lastName;
	private String telephone;
	private int age;
	private String ImagePath;
	private UserRole role;
	private String isActivated;
    
}
