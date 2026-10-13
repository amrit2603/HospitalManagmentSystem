package com.codingshuttle.jpaTutorial.jpaTuts.repository;

import com.codingshuttle.jpaTutorial.jpaTuts.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}