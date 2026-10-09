package com.codingshuttle.jpaTutorial.jpaTuts.service;

import com.codingshuttle.jpaTutorial.jpaTuts.entity.patient;
import com.codingshuttle.jpaTutorial.jpaTuts.repository.patientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class patientService {

    @Transactional
    public void testPatientTransaction() {

        patient p1 = patientRepository.findById(1L).orElseThrow();
        patient p2 = patientRepository.findById(1L).orElseThrow();

        System.out.println(p1 + " "+p2);
        System.out.println(p1 == p2);

        p1.setName("Random Name");
    }

    @Transactional
    public void deletePatient(Long patientId){
        patientRepository.findById(patientId).orElseThrow();
        patientRepository.deleteById(patientId);
    }
}
