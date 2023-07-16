package com.example.Booking_System.Service;


import com.example.Booking_System.Model.Person;
import com.example.Booking_System.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


    @Autowired
    PersonRepository personRepository;
    public Person addPerson(Person person) {

        person.setDose1Taken(false);
        person.setDos2Taken(false);
        Person savedPerson= personRepository.save(person);
        return savedPerson;
    }
}
