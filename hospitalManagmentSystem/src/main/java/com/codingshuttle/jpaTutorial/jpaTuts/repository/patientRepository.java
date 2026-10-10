package com.codingshuttle.jpaTutorial.jpaTuts.repository;

import com.codingshuttle.jpaTutorial.jpaTuts.dto.BloodGroupStats;
import com.codingshuttle.jpaTutorial.jpaTuts.dto.CPatientInfo;
import com.codingshuttle.jpaTutorial.jpaTuts.dto.IPatientInfo;
import com.codingshuttle.jpaTutorial.jpaTuts.entity.patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface patientRepository extends JpaRepository<patient, Long> {

    @Query("""
           select p.id as id, p.name as name, p.email as email
           from patient p
           """)
    List<IPatientInfo> getAllPatientsInfo();

    @Query("""
           select new com.codingshuttle.jpaTutorial.jpaTuts.dto.CPatientInfo(
               p.id,
               p.name
           )
           from patient p
           """)
    List<CPatientInfo> getAllPatientsInfoConcrete();

    @Query("""
           select new com.codingshuttle.jpaTutorial.jpaTuts.dto.BloodGroupStats(
               p.bloodGroup,
               count(p)
           )
           from patient p
           group by p.bloodGroup
           order by count(p) desc
           """)
    List<BloodGroupStats> getBloodGroupStats();

    @Transactional
    @Modifying
    @Query("""
           update patient p
           set p.name = :name
           where p.id = :id
           """)
    int updatePatietNameWithId(@Param("name") String ame, @Param("id") Long id);

    @Query("select pp from patient p LEFT JOIN FETCH p.appointments")
    List<patient> getAllPatientsWithAppointments();
}
