package com.codingshuttle.jpaTutorial.jpaTuts.repository;

import com.codingshuttle.jpaTutorial.jpaTuts.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}