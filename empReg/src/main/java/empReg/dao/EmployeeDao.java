package empReg.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import empReg.model.Employee;

@Repository
public class EmployeeDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createEmployee(Employee employee) {
		this.hibernateTemplate.saveOrUpdate(employee);
	}
	
	//get all products
	public List<Employee> getEmployees(){
		List<Employee> loadAll = this.hibernateTemplate.loadAll(Employee.class);
		return loadAll;
	}
	
	//delete a single product
	@Transactional
	public void deleteEmployee(int pid) {
		Employee product = this.hibernateTemplate.load(Employee.class, pid);
		this.hibernateTemplate.delete(product);
	}
	
	//get single item
	public Employee getEmployees(int pid) {
		Employee product = this.hibernateTemplate.get(Employee.class, pid);
		return product;
	}
}
