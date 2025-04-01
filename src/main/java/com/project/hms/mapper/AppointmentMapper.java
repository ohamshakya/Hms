package com.project.hms.mapper;

import com.project.hms.dto.AppointmentDto;
import com.project.hms.entity.Appointment;

public class AppointmentMapper {

    public static Appointment toEntity(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
        appointment.setStatus(appointmentDto.getStatus());
        return appointment;
    }

    public static AppointmentDto toDto(Appointment appointment) {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setAppointmentDate(appointment.getAppointmentDate());
        appointmentDto.setStatus(appointment.getStatus());
        return appointmentDto;
    }
}
