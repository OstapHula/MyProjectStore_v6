package ua.springboot.web.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.web.multipart.MultipartFile;

import ua.springboot.web.entity.enumeration.UserRole;

@NoArgsConstructor
@Getter
@Setter
public class EditUserRequest {

    	private int id;
    	private String email;
	private String firstName;
	private String lastName;
	private String address;
	private String telephone;
//	private Date birthday;
	private UserRole role;
	private MultipartFile file;
	private String oldImage;
	private String password;
	private String isActivated;
    
}
