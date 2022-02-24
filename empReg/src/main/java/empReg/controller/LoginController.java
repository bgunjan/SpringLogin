package empReg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import empReg.dao.EmployeeDao;
import empReg.model.Employee;
import empReg.model.Login;

@Controller
public class LoginController {
	@Autowired
	private EmployeeDao employeeDao;
		
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String loginUSer(@ModelAttribute Login login, Model m)
	{
		List<Employee> employees=employeeDao.getEmployees();
//		System.out.println(login);
		m.addAttribute("employees" , employees);
		for(Employee e:employees)
		{
//			System.out.println(e);
			String e1=e.getEmail(), e2=login.getEmail();
			String p1=e.getPassword(), p2=login.getPassword();
			if(e1.equals(e2)&&p1.equals(p2))
			{	
				m.addAttribute("name_user" , e1);
				return "index";
			}
		}
		return "loginPage";
	}
	
	
	
}
