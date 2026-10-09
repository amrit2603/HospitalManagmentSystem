package com.codingshuttle.jpaTutorial.jpaTuts.repository;

import com.codingshuttle.jpaTutorial.jpaTuts.entity.patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface patientRepository extends JpaRepository<patient, Long> {

    @Query("select p.id as id,p.name as name,p.email as email from Patient p")
    List<IpatientInfo> getAllPatientsInfo();
}
