package com.project.hms.mapper;

import com.project.hms.common.enums.Status;
import com.project.hms.dto.AppointmentDto;
import com.project.hms.dto.BillDto;
import com.project.hms.dto.MedicalRecordDto;
import com.project.hms.dto.PatientDto;
import com.project.hms.entity.*;

import java.util.ArrayList;
import java.util.List;

public class PatientMapper {

    public static Patient toEntity(PatientDto patientDto, Doctor doctor) {
        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setDob(patientDto.getDob());
        patient.setGender(patientDto.getGender());
        patient.setMobileNumber(patientDto.getMobileNumber());
        patient.setAge(patientDto.getAge());
        List<Appointment> appointmentList = new ArrayList<>();
        if (patientDto.getAppointmentDtoList() != null) {
            for (AppointmentDto dtoAppointment : patientDto.getAppointmentDtoList()) {
                if (dtoAppointment != null) {
                    Appointment appointment = new Appointment();
                    appointment.setAppointmentDate(dtoAppointment.getAppointmentDate());
                    appointment.setStatus(Status.PENDING);
                    appointment.setPatient(patient);
                    appointment.setDoctor(doctor);
                    appointmentList.add(appointment);
                }
            }
        }
        List<Bill> billList = new ArrayList<>();
        if (patientDto.getBillDtoList() != null) {
            for (BillDto dtoBill : patientDto.getBillDtoList()) {
                if (dtoBill != null) {
                    Bill bill = new Bill();
                    bill.setDate(dtoBill.getDate());
                    bill.setTotalAmount(dtoBill.getTotalAmount());
                    bill.setPatient(patient);
                    billList.add(bill);
                }
            }
        }
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        if(patientDto.getMedicalRecordDtoList() != null) {
            for(MedicalRecordDto dtoMedical : patientDto.getMedicalRecordDtoList()){
                if(dtoMedical != null){
                    MedicalRecord medicalRecord = new MedicalRecord();
                    medicalRecord.setDiagnosis(dtoMedical.getDiagnosis());
                    medicalRecord.setTreatment(dtoMedical.getTreatment());
                    medicalRecord.setPatient(patient);
                    medicalRecordList.add(medicalRecord);
                }
            }
        }
        patient.setMedicalRecordList(medicalRecordList);
        patient.setBillList(billList);
        patient.setAppointmentList(appointmentList);
        return patient;
    }

    public static PatientDto toDto(Patient patient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setId(patient.getId());
        patientDto.setName(patient.getName());
        patientDto.setDob(patient.getDob());
        patientDto.setGender(patient.getGender());
        patientDto.setMobileNumber(patient.getMobileNumber());
        patientDto.setAge(patient.getAge());
        List<AppointmentDto> appointmentDtoList = new ArrayList<>();
        if (patient.getAppointmentList() != null) {
            for (Appointment appointment : patient.getAppointmentList()) {
                if (appointment != null) {
                    AppointmentDto appointmentDto = new AppointmentDto();
                    appointmentDto.setId(appointment.getId());
                    appointmentDto.setAppointmentDate(appointment.getAppointmentDate());
                    appointmentDto.setStatus(appointment.getStatus());
                    appointmentDtoList.add(appointmentDto);
                }
            }
        }
        List<BillDto> billDtoList = new ArrayList<>();
        if (patient.getBillList() != null) {
            for (Bill bill : patient.getBillList()) {
                if (bill != null) {
                    BillDto billDto = new BillDto();
                    billDto.setId(bill.getId());
                    billDto.setDate(bill.getDate());
                    billDto.setTotalAmount(bill.getTotalAmount());
                    billDtoList.add(billDto);
                }
            }
        }
        List<MedicalRecordDto> medicalRecordDtoList = new ArrayList<>();
        if(patient.getMedicalRecordList() != null) {
            for(MedicalRecord dtoMedical : patient.getMedicalRecordList()){
                if(dtoMedical != null){
                    MedicalRecordDto medicalRecordDto = new MedicalRecordDto();
                    medicalRecordDto.setDiagnosis(dtoMedical.getDiagnosis());
                    medicalRecordDto.setTreatment(dtoMedical.getTreatment());
                    medicalRecordDto.setRecordDate(dtoMedical.getRecordDate());
                    medicalRecordDtoList.add(medicalRecordDto);
                }
            }
        }
        patientDto.setMedicalRecordDtoList(medicalRecordDtoList);
        patientDto.setBillDtoList(billDtoList);
        patientDto.setAppointmentDtoList(appointmentDtoList);
        return patientDto;
    }

    public static void toUpdate(Patient existingPatient, PatientDto patientDto, Integer id) {
        existingPatient.setName(patientDto.getName());
        existingPatient.setDob(patientDto.getDob());
        existingPatient.setGender(patientDto.getGender());
        existingPatient.setMobileNumber(patientDto.getMobileNumber());
        existingPatient.setAge(patientDto.getAge());

        List<Appointment> appointmentList = existingPatient.getAppointmentList();
        if (appointmentList == null) {
            appointmentList = new ArrayList<>();
            existingPatient.setAppointmentList(appointmentList);
        } else {
            appointmentList.clear();
        }

        if (patientDto.getAppointmentDtoList() != null) {
            for (AppointmentDto patientDto1 : patientDto.getAppointmentDtoList()) {
                if (patientDto1 != null) {
                    Appointment appointment = new Appointment();
                    appointment.setAppointmentDate(patientDto1.getAppointmentDate());
                    appointment.setStatus(patientDto1.getStatus());
                    appointment.setPatient(existingPatient);
                    appointmentList.add(appointment);
                }
            }
        }
    }

}
