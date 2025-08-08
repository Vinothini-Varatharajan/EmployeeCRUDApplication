package com.example.empCrud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//to create a table using entity annotation
@Entity
public class EmployeeDB {
	
	//to create a column using @id annotation
	@Id
	
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "EmployeeDB [id=" + id + ", name=" + name + "]";
	}
	
	

}
