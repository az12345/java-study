package nedis.demo.webtasks.services.mocks;

import java.util.Arrays;
import java.util.List;

import nedis.demo.webtasks.WebtasksConstants;
import nedis.demo.webtasks.model.Account;
import nedis.demo.webtasks.model.Role;

/**
 * @author nedis
 * @version 1.0
 */
class DataStorage implements WebtasksConstants {
	static final Role ADMIN_ROLE 			= new Role(ROLE_ADMIN, "Admin");
	static final Role STUDENT_ROLE 			= new Role(ROLE_USER, "Student");
	static final List<Role> ALL_ROLES 		= Arrays.asList(new Role[]{
			DataStorage.ADMIN_ROLE,
			DataStorage.STUDENT_ROLE,
	});
	
	static final Account ADMIN 				= new Account("admin", "password", ALL_ROLES);  
	static final Account STUDENT 			= new Account("student", "password", Arrays.asList(new Role[]{
			STUDENT_ROLE
	})); 
	
	static final List<Account> ALL_ACCOUNTS = Arrays.asList(new Account[]{
			DataStorage.ADMIN,
			DataStorage.STUDENT,
	});
}
