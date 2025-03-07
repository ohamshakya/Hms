package com.project.hms.mapper;

import com.project.hms.dto.DepartmentDto;
import com.project.hms.dto.DoctorDto;
import com.project.hms.entity.Department;
import com.project.hms.entity.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DepartmentMapper {
    public static Department toEntity(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setName(departmentDto.getName());
        List<Doctor> doctorList = new ArrayList<>();
        if(departmentDto.getDoctorDtoList() != null){
            for(DoctorDto doctorDto : departmentDto.getDoctorDtoList()){
                if(doctorDto != null) {
                    Doctor doctor = new Doctor();
                    doctor.setName(doctorDto.getName());
                    doctor.setSpeciality(doctorDto.getSpeciality());
                    doctor.setContactNumber(doctorDto.getContactNumber());
                    doctor.setDepartment(department);
                    doctorList.add(doctor);
                }
            }
        }
        department.setDoctorList(doctorList);
        return department;
    }

    public static DepartmentDto toDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName(department.getName());
        List<DoctorDto> doctorDtoList = new ArrayList<>();

        if (department.getDoctorList() != null) {
            for (Doctor doctor : department.getDoctorList()) {
                if (doctor != null) {
                    DoctorDto doctorDtos = new DoctorDto();
                    doctorDtos.setName(doctor.getName());
                    doctorDtos.setSpeciality(doctor.getSpeciality());
                    doctorDtos.setContactNumber(doctor.getContactNumber());
                    doctorDtos.setDepartment(departmentDto);
                    doctorDtoList.add(doctorDtos);
                }
            }
        }
        departmentDto.setDoctorDtoList(doctorDtoList);
        return departmentDto;
    }

    public static void toUpdate(Department existingDepartment, DepartmentDto departmentDto, Integer id) {
        existingDepartment.setName(departmentDto.getName());

        List<Doctor> doctorList = existingDepartment.getDoctorList();
        if (doctorList == null) {
            doctorList = new ArrayList<>();
            existingDepartment.setDoctorList(doctorList);
        } else {
            doctorList.clear();
        }

        // Add updated doctors from the DTO
        if (departmentDto.getDoctorDtoList() != null) {
            for (DoctorDto doctorDto : departmentDto.getDoctorDtoList()) {
                if (doctorDto != null) {
                    Doctor doctor = new Doctor();
                    doctor.setName(doctorDto.getName());
                    doctor.setSpeciality(doctorDto.getSpeciality());
                    doctor.setContactNumber(doctorDto.getContactNumber());
                    doctor.setDepartment(existingDepartment); // Set bidirectional relationship
                    doctorList.add(doctor);
                }
            }
        }
    }
}
