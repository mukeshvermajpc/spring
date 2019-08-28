package com.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Service
@Repository
public class EmployeeRepository {

@Autowired
JdbcTemplate template;
   public List<Employee>getAllEmployee()
   {
	   EmployeeMapper empMapper=new EmployeeMapper();
	   return template.query("select *from employee",empMapper );
   }
   public Employee getEmployee(Integer id)
   {
	  String sql="select * from employee where id=?";
	  EmployeeMapper empMapper=new EmployeeMapper();
	  return template.queryForObject(sql, new Object[] {id}, empMapper);
   }
   
   public int createEmployee(Employee employee)
   {
	   String sql="insert into employee(id,name,department,salary) values(?,?,?,?)";
	  return template.update(sql, employee.getId(),employee.getName(),employee.getDept(),employee.getSalary());
   }
   public int updateEmployee(Employee employee)
   {
	   String sql="update employee set name=?,department=?,salary=? where id=?";
	   return template.update(sql,employee.getName(),employee.getDept(),employee.getSalary(),employee.getId());
   }
   public int deleteEmployee(Integer id)
   {
	   String sql="delete from employee where id=?";
	  return template.update(sql,id);
   }
   public int countEmployee()
   {
	   String sql="select count(*) from employee";
	   return template.queryForObject(sql,Integer.TYPE);
   }
   

}
