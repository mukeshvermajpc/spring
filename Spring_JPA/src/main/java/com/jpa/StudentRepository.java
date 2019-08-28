package com.jpa;
import org.springframework.data.repository.CrudRepository;
public interface StudentRepository extends CrudRepository<Student,Long> {
	long countByCourse(String course);
	long countByLocation(String location);
	
}
