package com.test;

import com.test.controller.AppointmentController;
import com.test.db.AppointmentRepository;
import com.test.mapper.RequestMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RequestMapper mapper;
    @MockBean
    private AppointmentRepository repository;

    @Test
    public void testGet() {
        List<Appointment> mockAppointments = new ArrayList<>();
        Appointment appointment = new Appointment();
        appointment.setDescription("Breakfast");
        mockAppointments.add(appointment);
        when(mapper.mapGetMethod(repository)).thenReturn(mockAppointments);

        List<Appointment> appointments = mapper.mapGetMethod(repository);
        System.out.println(appointments.size());

        Assert.assertEquals(appointments.get(0).getDescription(), appointment.getDescription());
    }

}
