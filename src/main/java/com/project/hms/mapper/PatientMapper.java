package com.project.hms.mapper;

import com.project.hms.dto.AppointmentDto;
import com.project.hms.dto.PatientDto;
import com.project.hms.entity.Appointment;
import com.project.hms.entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientMapper {

    public static Patient toEntity(PatientDto patientDto){
        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setDob(patientDto.getDob());
        patient.setGender(patientDto.getGender());
        patient.setMobileNumber(patientDto.getMobileNumber());
        patient.setAge(patientDto.getAge());
        List<Appointment> appointmentList = new ArrayList<>();
        if(patientDto.getAppointmentDtoList() != null){
            for(AppointmentDto dtoAppointment : patientDto.getAppointmentDtoList()){
                if(dtoAppointment != null){
                    Appointment appointment = new Appointment();
                    appointment.setAppointmentDate(dtoAppointment.getAppointmentDate());
                    appointment.setStatus(dtoAppointment.getStatus());
                    appointment.setPatient(patient);
                    appointmentList.add(appointment);
                }
            }
        }
        patient.setAppointmentList(appointmentList);
        return patient;
    }

    public static PatientDto toDto(Patient patient){
        PatientDto patientDto = new PatientDto();
        patientDto.setId(patient.getId());
        patientDto.setName(patient.getName());
        patientDto.setDob(patient.getDob());
        patientDto.setGender(patient.getGender());
        patientDto.setMobileNumber(patient.getMobileNumber());
        patientDto.setAge(patient.getAge());
        List<AppointmentDto> appointmentDtoList = new ArrayList<>();
        if(patient.getAppointmentList() != null){
            for(Appointment appointment : patient.getAppointmentList()){
                if(appointment != null){
                    AppointmentDto appointmentDto = new AppointmentDto();
                    appointmentDto.setId(appointment.getId());
                    appointmentDto.setAppointmentDate(appointment.getAppointmentDate());
                    appointmentDto.setStatus(appointment.getStatus());
                    appointmentDto.setPatient(patient);
                    appointmentDtoList.add(appointmentDto);
                }
            }
        }
        patientDto.setAppointmentDtoList(appointmentDtoList);
        return patientDto;
    }

    public static void toUpdate(Patient existingPatient, PatientDto patientDto, Integer id){
        existingPatient.setName(patientDto.getName());
        existingPatient.setDob(patientDto.getDob());
        existingPatient.setGender(patientDto.getGender());
        existingPatient.setMobileNumber(patientDto.getMobileNumber());
        existingPatient.setAge(patientDto.getAge());

        List<Appointment> appointmentList = existingPatient.getAppointmentList();
        if(appointmentList == null){
            appointmentList = new ArrayList<>();
            existingPatient.setAppointmentList(appointmentList);
        }else{
            appointmentList.clear();
        }

        if( patientDto.getAppointmentDtoList() != null){
            for(AppointmentDto patientDto1 : patientDto.getAppointmentDtoList()){
                if(patientDto1 != null){
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
