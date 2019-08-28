package com.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ReportAsSingleViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;

	public List<Student> getAllStudent() {
		List<Student> list = new ArrayList<>();
		repository.findAll().forEach(list::add);
		return list;
	}

	public Optional<Student> getUser(Long id) {
		return repository.findById(id);
	}

	public void addStudent(Student student) {
		repository.save(student);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Student getUpdate(Long id, Student student) {
		Optional<Student> student1 = repository.findById(id);
		if (student1.isPresent()) {
			Student st = student1.get();
			st.setName(student.getName());
			st.setCourse(st.getCourse());
			st.setLocation(student.getLocation());
			st = repository.save(st);
			return st;
		} else {
			student = repository.save(student);
			return student;
		}
	}
	public long getCourseCount(String course) {
		return repository.countByCourse(course);
	}
	public long getLocationCount(String location) {
		return repository.countByLocation(location);
	}
    public long totalCount()
    {
    	return repository.count();
    }
}
