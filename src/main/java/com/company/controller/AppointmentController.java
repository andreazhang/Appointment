package com.company.controller;

import com.company.Appointment;
import com.company.db.AppointmentRepository;
import com.company.mapper.RequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

    @GetMapping("/")
    public String index(Model model){
        updateAppointmentsList(model);

        model.addAttribute("appointment", new Appointment());
        return "index";
    }

    @GetMapping("/appointments")
    public String getAppointments(Model model){
        RequestMapper mapper = new RequestMapper();
        updateAppointmentsList(model);

        model.addAttribute("appointment", new Appointment());
        return "index";
    }

    @PostMapping("/appointments/create")
    public String newAppointment(@ModelAttribute @Valid Appointment appointment, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            updateAppointmentsList(model);
            return "index";
        }

        RequestMapper mapper = new RequestMapper();
        mapper.mapPostMethod(repository, appointment);

        updateAppointmentsList(model);

        model.addAttribute("appointment", new Appointment());
        return "index";
    }

    private void updateAppointmentsList(Model model) {
        RequestMapper mapper = new RequestMapper();
        List<Appointment> appointments = mapper.mapGetMethod(repository);
        model.addAttribute("appointments", appointments);
    }

}
