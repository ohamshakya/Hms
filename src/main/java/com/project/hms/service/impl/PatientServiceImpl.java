package com.project.hms.service.impl;

import com.project.hms.common.exception.AlreadyExistsException;
import com.project.hms.common.exception.ResourceNotFoundException;
import com.project.hms.common.utils.Messages;
import com.project.hms.dto.PatientDto;
import com.project.hms.entity.Doctor;
import com.project.hms.entity.Patient;
import com.project.hms.mapper.PatientMapper;
import com.project.hms.repository.DoctorRepo;
import com.project.hms.repository.PatientRepo;
import com.project.hms.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PatientServiceImpl implements PatientService {

    @Autowired
    private final PatientRepo patientRepo;


    private final DoctorRepo doctorRepo;

    public PatientServiceImpl(PatientRepo patientRepo, DoctorRepo doctorRepo) {
        this.patientRepo = patientRepo;
        this.doctorRepo = doctorRepo;
    }

    @Override
    @Transactional
    public PatientDto save(PatientDto patientDto, Integer id) {
        log.info("inside save patient : service");
        Doctor doctorId = doctorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Messages.DOCTOR_NOT_FOUND));
        Patient existingPatient = patientRepo.findByName(patientDto.getName());
        if (existingPatient != null) {
            throw new AlreadyExistsException("Patient with name " + patientDto.getName() + " already exists");
        }
        Patient patient = PatientMapper.toEntity(patientDto, doctorId);
        patientRepo.save(patient);
        return PatientMapper.toDto(patient);
    }

    @Override
    @Transactional
    public PatientDto update(PatientDto patientDto, Integer id) {
        log.info("inside patient update : service");
        Patient existingPatient = patientRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Messages.PATIENT_NOT_FOUND));
        PatientMapper.toUpdate(existingPatient, patientDto, id);
        Patient finalResult = patientRepo.save(existingPatient);
        return PatientMapper.toDto(finalResult);
    }

    @Override
    public PatientDto getById(Integer id) {
        log.info("inside get patient By Id  : service");
        Patient existingPatient = patientRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Messages.PATIENT_NOT_FOUND));
        return PatientMapper.toDto(existingPatient);
    }

    @Override
    public List<PatientDto> getAll() {
        log.info("inside getAll patient : service");
        List<Patient> patientList = patientRepo.findAll();
        return patientList.stream().map(PatientMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        log.info("inside delete patient : service");
        Patient existingPatient = patientRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Messages.PATIENT_NOT_FOUND));
        patientRepo.delete(existingPatient);

    }

    @Override
    public List<PatientDto> search(String query, Pageable pageable) {
        log.info("inside search patient: service");
        List<Patient> listResponse = patientRepo.search(query, pageable);
        return listResponse.stream().map(PatientMapper::toDto).collect(Collectors.toList());
    }

//    @Override
//    public String approveAppointment(Integer id) {
//        try {
//            Patient response = checkIfExist(id);
//            List<Appointment> appointmentList = new ArrayList<>();
//            if(appointmentList != null) {
//                for (Appointment appointment : response.getAppointmentList()) {
//                    Appointment appointment1 = new Appointment();
//                    appointment1.setStatus(Status.SCHEDULED);
//                    appointment1.setDoctor(Doctor.builder()
//                            .name(appointment.getDoctor().getName())
//                            .contactNumber(appointment.getDoctor().getContactNumber())
//                            .build());
//                    appointmentList.add(appointment1);
//                }
//            }
//            response.setAppointmentList(appointmentList);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//        throw new ResourceNotFoundException("NOt found");
//    }

    @Override
    public Patient checkIfExist(Integer id) {
        log.info("check if exist patient : service");
        return patientRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }
}
