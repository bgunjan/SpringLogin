package empReg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import empReg.dao.EmployeeDao;
import empReg.model.Employee;

@Controller
public class FirstPageController {
	@Autowired
	private EmployeeDao employeeDao;

	// showing the
	@RequestMapping("/")
	public String show_firstPage() {
		return "first_page";
	}
//	*****************************    Handling the buttons on the first page  **************

	// handling the list of users
	@RequestMapping("/handle_list_of_users")
	public String show_listOfUsers(Model m) {
		List<Employee> employees = employeeDao.getEmployees();
		m.addAttribute("employees", employees);
		return "listUsers";
	}

	// handling the register button
	@RequestMapping("/open_register_page")
	public String addUsers() {
		return "add_employee_form";
	}

	// show login page on clicking
	@RequestMapping("/loginPage")
	public String show_loginPage() {
		return "loginPage";
	}


	
	
	
}
