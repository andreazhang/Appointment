package com.company.mapper;

import com.company.Appointment;

import java.util.Comparator;

public class AppointmentDateComparator implements Comparator<Appointment> {

    @Override
    public int compare(Appointment appointment1, Appointment appointment2) {
        return appointment1.getDate().compareTo(appointment2.getDate());
    }

}
