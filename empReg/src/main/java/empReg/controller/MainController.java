package empReg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import empReg.dao.EmployeeDao;
import empReg.model.Employee;



@Controller
public class MainController {
	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping("/index")
	public String home(Model m) {
		List<Employee> employees = employeeDao.getEmployees();
		m.addAttribute("employees" , employees);
//		for(Product p:products)
//			System.out.println(p);
		return "index";
	}
	@RequestMapping("/add-employee")
	public String addEmployee(Model m) {
		m.addAttribute("title", "Add employee");
		return "add_employee_form";
	}
	//Handle product page 
	@RequestMapping(path="/handle-employee" , method=RequestMethod.POST)
	public String handleEmployee(@ModelAttribute Employee employee, HttpServletRequest request) {
		System.out.println(employee);
		employeeDao.createEmployee(employee);
//		RedirectView redirectView = new RedirectView();
//		redirectView.setUrl(request.getContextPath() + "/success_login");
		return "success_login";
	}
	
//	delete handler
	@RequestMapping("/delete/{employeeId}")
	public RedirectView deleteEmployee(@PathVariable("employeeId") int employeeId ,HttpServletRequest request) {
		this.employeeDao.deleteEmployee(employeeId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}
	
//	handle update query
	@RequestMapping("/update/{employeeId}")
	public String updateEmp(@PathVariable("employeeId") int eid ,Model model) {
		Employee employee = this.employeeDao.getEmployees(eid);
		model.addAttribute("employee", employee);
		return "update_form";
	}
	
}