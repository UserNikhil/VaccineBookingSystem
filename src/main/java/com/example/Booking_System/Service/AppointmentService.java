package com.example.Booking_System.Service;

import com.example.Booking_System.Dto.Request.BookAppointmentRequestDto;
import com.example.Booking_System.Dto.Response.BookAppointmentResponseDto;
import com.example.Booking_System.Dto.Response.CenterResponseDto;
import com.example.Booking_System.Exception.DoctorNotFoundException;
import com.example.Booking_System.Exception.PersonNotFoundException;
import com.example.Booking_System.Model.Appointment;
import com.example.Booking_System.Model.Doctor;
import com.example.Booking_System.Model.Person;
import com.example.Booking_System.Model.VaccinationCenter;
import com.example.Booking_System.Repository.AppointmentRepository;
import com.example.Booking_System.Repository.DoctorRespository;
import com.example.Booking_System.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    DoctorRespository doctorRespository;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public BookAppointmentResponseDto bookAppointment(BookAppointmentRequestDto bookAppointmentRequestDto) {

        Optional<Person> optionalPerson = personRepository.findById(bookAppointmentRequestDto.getPersonId());
        if (optionalPerson.isEmpty()) {
            throw new PersonNotFoundException("Invalid personId");
        }

        Optional<Doctor> optionalDoctor = doctorRespository.findById(bookAppointmentRequestDto.getDoctorId());
        if (optionalDoctor.isEmpty()) {
            throw new DoctorNotFoundException("Invalid DoctorId");
        }

        Person person = optionalPerson.get();
        Doctor doctor = optionalDoctor.get();

        // create an appointment object
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setPerson(person);
        appointment.setDoctor(doctor);

        Appointment savedAppointment = appointmentRepository.save(appointment);

        doctor.getAppointments().add(savedAppointment);
        person.getAppointments().add(savedAppointment);

        Doctor savedDoctor = doctorRespository.save(doctor);
        Person savedPerson = personRepository.save(person);
        VaccinationCenter center = savedDoctor.getCenter();

        // send an email
        String text = "Congrats!! " + savedPerson.getName() + " Your appointment has been booked with Doctor " +
                savedDoctor.getName() + ". Your vaccination center name is: " + center.getCenterName() + " Please reach at this address " +
                center.getAddress() + " at this time: " + savedAppointment.getAppointmentDate() + " Responsible Citizen ";

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("acciojobspring@gmail.com");
        simpleMailMessage.setTo(savedPerson.getEmailId());
        simpleMailMessage.setSubject("Congrats!! Appointment Done!!");
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);

        // prepare the response dto;

        CenterResponseDto centerResponseDto = new CenterResponseDto();
        centerResponseDto.setCenterName(center.getCenterName());
        centerResponseDto.setAddress(center.getAddress());
        centerResponseDto.setCenterType(center.getCenterType());

        BookAppointmentResponseDto bookAppointmentResponseDto = new BookAppointmentResponseDto();
        bookAppointmentResponseDto.setPersonName(savedPerson.getName());
        bookAppointmentResponseDto.setDoctorName(savedDoctor.getName());
        bookAppointmentResponseDto.setAppointmentId(savedAppointment.getAppointmentId());
        bookAppointmentResponseDto.setAppointmentDate(savedAppointment.getAppointmentDate());
        bookAppointmentResponseDto.setCenterResponseDto(centerResponseDto);

        return bookAppointmentResponseDto;


    }
}

