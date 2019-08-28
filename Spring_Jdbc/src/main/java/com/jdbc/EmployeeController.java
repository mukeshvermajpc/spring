package com.jdbc;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
@Autowired
EmployeeRepository repository;

@RequestMapping("/employees")
public List<Employee>getAllEmployee()
{
	return repository.getAllEmployee();
}
@GetMapping("/employee/{id}")
public Employee getEmployee(@PathVariable("id") Integer id)
{
	return repository.getEmployee(id);
}
@PostMapping("/create")
public String addEmployee(@RequestBody Employee employee)
{
	int status=repository.createEmployee(employee);
	if(status>0)
		return "insertion is successfull";
	else
		return "fail";
}
@PutMapping("/update")
public String updateEmployee(@RequestBody Employee employee)
{
   int status=repository.updateEmployee(employee);
   if(status>0)
	   return "updated successfully";
   else
	   return "unable to update employee record";
}
@DeleteMapping("/delete/{id}")
public String deleteEmployee(@PathVariable("id") Integer id)
{
	
	int status=repository.deleteEmployee(id);
	if(status>0)
		return "record for this id "+id+" deleted successfully";
	else
		return "record is not found or not deleted";
}
@GetMapping("/count")
public String getEmployeeCount()
{
     int count=repository.countEmployee();
     return "total number of employee is"+count;
}
}