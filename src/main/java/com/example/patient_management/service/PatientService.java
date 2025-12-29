package com.example.patient_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.patient_management.dto.PatientRequestDTO;
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

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        Patient newPatient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(newPatient); 
    }
}
