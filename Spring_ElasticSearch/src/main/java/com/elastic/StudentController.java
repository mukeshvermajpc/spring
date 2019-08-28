package com.elastic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository repository;
	@PostMapping("/student/add")
	public Student addStudent(@RequestBody Student student ){
		return repository.save(student);
	}
	@GetMapping("/student/all")
	public List<Student>getStudents()
	{
		Iterator<Student>iterator=repository.findAll().iterator();
		List<Student>list=new ArrayList<>();
		while(iterator.hasNext())
		{
			list.add(iterator.next());
		}
		return list;
	}
	@GetMapping("student/{id}")
	public Optional<Student> getStudent(@PathVariable Integer id)
	{
		return repository.findById(id);
		
	}
	@DeleteMapping("student/{id}")
	public String deleteStudent(@PathVariable Integer id)
	{
		repository.deleteById(id);
		return "record deleted";
	}
	@PutMapping("student/{id}")
	public Student updateStudent(@PathVariable Integer id,@RequestBody Student student)
	{
		Optional<Student>stu=repository.findById(id);
		if(stu.isPresent())
		{
			Student st=stu.get();
			st.setCourse(student.getCourse());
			st.setName(student.getName());
			st.setLocation(student.getLocation());
			return repository.save(st);
		}
		else
		{
			return null;
		}
	}	
}
