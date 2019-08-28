package com.jpa;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
   @Autowired
   public StudentService service;
   @GetMapping("/students")
   public List<Student>getAllStudent()
   {
	   return service.getAllStudent();
   }
   @PostMapping("/add")
   public String addStudent(@RequestBody Student student)
   {
	   service.addStudent(student);
	   return "new student added successfully";
   }
   @GetMapping("/student/{id}")
   public Optional<Student> getStudent(@PathVariable(value="id")Long id)
   {
	   return service.getUser(id);
   }
   @DeleteMapping("/delete/{id}")
   public String deleteStudent(@PathVariable(value="id")Long id)
   {
	   service.delete(id);
	   return "record deleted successfully";
   }
   @PutMapping("/update/{id}")
   public Student updateStudent(@PathVariable(value="id") Long id,@RequestBody Student student)
   {
	   return service.getUpdate(id, student);
   }
	@GetMapping("/course/{course}")
	  public String countByCourse(@PathVariable(value="course")String course) {
	        long crs=service.getCourseCount(course);  
	      return "Total number of student in "+course+" is "+crs;  
	}
	@GetMapping("/location/{location}")
	public String getLocationCount(@PathVariable(value="location")String location)
	{
	     long loc=service.getLocationCount(location);
	     return "Total number of student in"+location+" is "+loc;
	}
	@GetMapping("/total")
	public String getTotal()
	{
		long total=service.totalCount();
		return "Total number of student is "+total;
	}
}
