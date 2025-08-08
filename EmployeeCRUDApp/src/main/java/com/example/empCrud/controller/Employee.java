package com.example.empCrud.controller;

import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.empCrud.model.EmployeeDB;
import com.example.empCrud.repository.EmployeeDBRepository;

@Controller
public class Employee {
	
	@Autowired
	EmployeeDBRepository repo;
	
	
	@RequestMapping("/")
	public String homeMethod() {
		return "home";
	}
	
	@RequestMapping("/create")
	public String create() {
		return "create";
	}
	
	@RequestMapping("/created")
	public String createdMethod(EmployeeDB obj) {
		repo.save(obj);
		return "home";
	}
	
	@RequestMapping("/read")
	public String show(Model obj) {
		List<EmployeeDB>list = repo.findAll();
		obj.addAttribute("temp",list);
		return "show";
	}
	
	@RequestMapping("/update")
	public String update() {
		return "update";
	}
	
	@RequestMapping("/updating")
     public ModelAndView upd(EmployeeDB obj) {
		
		ModelAndView mav = new ModelAndView("create");
		obj = repo.findById(obj.getId()).orElse(obj);
		repo.deleteById(obj.getId());
		mav.addObject(obj);
		return mav;
		
	}
	@RequestMapping("/delete")
	public String delete() {
		return "delete";
	}
	
	
	@RequestMapping("/deleting")
     public ModelAndView del(@RequestParam int id) {
		
		ModelAndView mav = new ModelAndView("deleted");
		EmployeeDB obj = repo.findById(id).orElse(new EmployeeDB());
		repo.deleteById(id);
		mav.addObject("temp",obj);
		return mav;
    
}
}

