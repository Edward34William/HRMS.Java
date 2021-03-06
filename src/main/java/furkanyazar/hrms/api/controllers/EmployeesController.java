package furkanyazar.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import furkanyazar.hrms.business.abstracts.EmployeeService;
import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeesController {
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employee employee) {
		return employeeService.add(employee);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employee>> getAll() {
		return employeeService.getAll();
	}
	
	@GetMapping("/findbyemail")
	public DataResult<List<Employee>> findByEmail(String email) {
		return employeeService.findByEmail(email);
	}
	
	@GetMapping("/findbyidentitynumber")
	public DataResult<List<Employee>> findByIdentityNumber(String identityNumber) {
		return employeeService.findByIdentityNumber(identityNumber);
	}

	@GetMapping("findbyid")
	public DataResult<Employee> findById(int id) {
		return employeeService.findById(id);
	}

	@GetMapping("findbyemailandpassword")
	public DataResult<Employee> findByEmailAndPassword(String email, String password) {
		return employeeService.findByEmailAndPassword(email, password);
	}

	@PostMapping("/edit")
	public Result edit(String coverLetter, String github, String linkedin, @RequestBody Employee employee, int id) {
		return employeeService.edit(coverLetter, github, linkedin, employee, id);
	}

}
