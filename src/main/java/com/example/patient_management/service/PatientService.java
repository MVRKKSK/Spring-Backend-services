package com.example.patient_management.service;

import org.springframework.stereotype.Service;

import java.util.*;

import com.example.patient_management.dto.PatientResponseDTO;
import com.example.patient_management.mapper.PatientMapper;
import com.example.patient_management.model.Patient;
import com.example.patient_management.repository.PatientRepository;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOs = patients.stream().map(patient -> PatientMapper.toDTO(patient)).toList();
        return patientResponseDTOs;
    }
}
