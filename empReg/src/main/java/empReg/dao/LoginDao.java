package empReg.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import empReg.model.Employee;
import empReg.model.Login;

@Repository
public class LoginDao implements LoginDaoInterface{
	@Autowired
	private EmployeeDao employeeDao;
		
	public Employee validate_user(Login login) {
		System.out.println("Login =" + login);
		
		List<Employee> loadAll = this.employeeDao.getEmployees();
		for(Employee e: loadAll) {
			System.out.println(e);
			String e1=e.getEmail(), e2=login.getEmail();
			String p1=e.getPassword(), p2=login.getPassword();
			if(e1.equals(e2)&&p1.equals(p2)) {
				System.out.println(e);
				return e;
			}
		}
		return null; 
	}
	
}
