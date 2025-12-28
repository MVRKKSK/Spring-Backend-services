package com.example.patient_management.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.patient_management.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
}
