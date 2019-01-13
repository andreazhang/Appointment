package com.company.mapper;

import com.company.Appointment;
import com.company.db.AppointmentRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RequestMapper {

    public List<Appointment> mapGetMethod(AppointmentRepository repository){
        List<Appointment> appointments = repository.findAll();
        AppointmentDateComparator comparator = new AppointmentDateComparator();
        Collections.sort(appointments, comparator);
        return appointments;
    }

    public void mapPostMethod(AppointmentRepository repository, Appointment appointment){
        repository.save(appointment);
    }

    public void mapDeleteMethod(AppointmentRepository repository, Long id) {
        repository.deleteById(id);
    }
}
