package com.codingshuttle.jpaTutorial.jpaTuts.service;

import com.codingshuttle.jpaTutorial.jpaTuts.entity.Appointment;
import com.codingshuttle.jpaTutorial.jpaTuts.entity.Doctor;
import com.codingshuttle.jpaTutorial.jpaTuts.entity.Insurance;
import com.codingshuttle.jpaTutorial.jpaTuts.entity.Patient;
import com.codingshuttle.jpaTutorial.jpaTuts.repository.AppointmentRepository;
import com.codingshuttle.jpaTutorial.jpaTuts.repository.DoctorRepository;
import com.codingshuttle.jpaTutorial.jpaTuts.repository.InsuranceRepository;
import com.codingshuttle.jpaTutorial.jpaTuts.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createANewAppointment(Appointment appointment, Long patientId, Long doctorId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);

        return appointment;
    }


}