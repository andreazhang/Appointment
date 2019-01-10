package com.company.mapper;

import com.company.Appointment;
import com.company.db.AppointmentRepository;

import java.util.List;

public class RequestMapper {

    public List<Appointment> mapGetMethod(AppointmentRepository repository){
        return repository.findAll();
    }

    public void mapPostMethod(AppointmentRepository repository, Appointment appointment){
        repository.save(appointment);
    }

}
