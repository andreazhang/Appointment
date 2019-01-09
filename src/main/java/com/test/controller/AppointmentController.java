package com.test.controller;

import com.test.Appointment;
import com.test.db.AppointmentRepository;
import com.test.mapper.RequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentRepository repository;

    @GetMapping("/appointments")
    public String getAppointments(Model model){
        RequestMapper mapper = new RequestMapper();
        updateAppointmentsList(model, mapper);

        model.addAttribute("appointment", new Appointment());
        return "index";
    }

    @PostMapping("/appointments/create")
    public String newAppointment(@ModelAttribute @Valid Appointment appointment, BindingResult bindingResult, Model model){
        RequestMapper mapper = new RequestMapper();

        if(bindingResult.hasErrors()){
            updateAppointmentsList(model, mapper);
            return "index";
        }

        mapper.mapPostMethod(repository, appointment);

        updateAppointmentsList(model, mapper);
        model.addAttribute("appointment", new Appointment());
        return "index";
    }

    private void updateAppointmentsList(Model model, RequestMapper mapper) {
        List<Appointment> appointments = mapper.mapGetMethod(repository);
        model.addAttribute("appointments", appointments);
    }

}
