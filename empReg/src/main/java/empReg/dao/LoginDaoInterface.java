package empReg.dao;

import empReg.model.Employee;
import empReg.model.Login;

public interface LoginDaoInterface {
	public Employee validate_user(Login login);
}
