package com.example.empCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.empCrud.model.EmployeeDB;

@Repository
public interface EmployeeDBRepository extends JpaRepository<EmployeeDB, Integer>{

}
