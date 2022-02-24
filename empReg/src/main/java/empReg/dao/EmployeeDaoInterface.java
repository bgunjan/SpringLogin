package empReg.dao;

import java.util.List;

import empReg.model.Employee;

public interface EmployeeDaoInterface {
	public void createEmployee(Employee employee);
	public List<Employee> getEmployees();
	public void deleteEmployee(int pid);
	public Employee getEmployees(int pid);
}
