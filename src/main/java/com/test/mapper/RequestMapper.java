package com.test.mapper;

import com.test.Appointment;
import com.test.db.AppointmentRepository;

import java.util.List;

public class RequestMapper {

    public List<Appointment> mapGetMethod(AppointmentRepository repository){

        return repository.findAll();
    }

    public void mapPostMethod(AppointmentRepository repository, Appointment appointment){
        repository.save(appointment);
    }

}
