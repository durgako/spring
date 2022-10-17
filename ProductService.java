package com.secondspring.secondspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService
{
	@Autowired
	  Myrepo myrepo;
	public  List<Employee> displayEmployee()
	{
		 return myrepo.findAll();
	}
	public void addEmployee(Employee employee)
	{
		myrepo.save(employee);
	}
	public Employee updateEmp(long id)
	{
		return myrepo.findById(id).get();
	}
	public void deleteEmp(long id)
	{
		myrepo.deleteById(id);
	}
}














